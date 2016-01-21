package com.turingoal.cms.modules.base.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.modules.base.domain.Info;
import com.turingoal.cms.modules.base.domain.Tag;
import com.turingoal.cms.modules.base.domain.form.InfoForm;
import com.turingoal.cms.modules.base.domain.form.TagForm;
import com.turingoal.cms.modules.base.domain.query.TagQuery;
import com.turingoal.cms.modules.base.repository.TagDao;
import com.turingoal.cms.modules.base.service.TagService;
import com.turingoal.common.annotation.MethodLog;
import com.turingoal.common.util.lang.StringUtil;

/**
 * 标签Service
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagDao tagDao;
    @Autowired
    private InfoServiceImpl infoServiceImpl;

    /**
     * 分页查询 Tag
     */
    @MethodLog(name = "分页查询标签", description = "根据条件分页查询标签")
    public Page<Tag> findByPage(final TagQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        return (Page<Tag>) tagDao.find(query);
    }

    /**
     * 通过id得到一个 标签
     */
    @MethodLog(name = "通过id得到标签", description = "通过id得到一个标签")
    public Tag get(final String id) {
        return tagDao.get(id);
    }

    /**
     * 通过name得到一个 标签
     */
    @MethodLog(name = "通过name得到标签", description = "通过name得到一个标签")
    public Tag findByName(final String name) {
        return tagDao.findByName(name);
    }

    /**
     * 根据infoId获取 标签
     */
    @MethodLog(name = "通过文章id得到标签", description = "通过id得到标签")
    public List<Tag> findByInfoId(final String infoId) {
        return tagDao.findByInfoId(infoId);
    }

    /**
     * 新增 标签
     */
    @MethodLog(name = "新增标签", description = "新增一个标签")
    public void add(final TagForm form) {
        form.setRefers(0);
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        tagDao.add(form);
    }

    /**
     * 修改 标签
     */
    @MethodLog(name = "修改标签", description = "修改一个标签")
    public int update(final TagForm form) {
        Tag tag = this.get(form.getId());
        String oldTagName = tag.getTagName();
        String newTagName = form.getTagName();
        List<Info> infoList = infoServiceImpl.findByTagId(form.getId());
        for (Info info : infoList) {
            InfoForm infoForm = new InfoForm();
            String metaKeywords = info.getMetaKeywords();
            metaKeywords = metaKeywords.replace(oldTagName, newTagName);
            infoForm.setId(info.getId());
            infoForm.setMetaKeywords(metaKeywords);
            infoServiceImpl.updateMetaKeywords(infoForm);
        }
        form.setRefers(tag.getRefers());
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        return tagDao.update(form);
    }

    /**
     * 根据id删除一个 标签
     */
    @MethodLog(name = "删除标签", description = "根据id删除一个标签")
    public int delete(final String id) {
        Tag tag = this.get(id);
        String tagName = tag.getTagName();
        List<Info> infoList = infoServiceImpl.findByTagId(id);
        for (Info info : infoList) {
            InfoForm form = new InfoForm();
            String metaKeywords = info.getMetaKeywords();
            if (metaKeywords.contains("," + tagName)) {
                metaKeywords = metaKeywords.replace("," + tagName, "");
            } else if (metaKeywords.contains(tagName + ",")) {
                metaKeywords = metaKeywords.replace(tagName + ",", "");
            } else if (metaKeywords.contains(tagName)) {
                metaKeywords = metaKeywords.replace(tagName, "");
            }
            form.setId(info.getId());
            form.setMetaKeywords(metaKeywords);
            infoServiceImpl.updateMetaKeywords(form);
            this.deleteRelation(info.getRelationId());
        }
        return tagDao.delete(id);
    }

    /**
     * 新增文章、标签关系
     */
    @MethodLog(name = "新增文章、标签关系", description = "新增文章、标签关系")
    public void addRelation(final TagForm form) {
        tagDao.addRelation(form);
    }

    /**
     * 删除文章、标签关系
     */
    @MethodLog(name = "删除文章、标签关系", description = "删除文章、标签关系")
    public int deleteRelation(final String id) {
        return tagDao.deleteRelation(id);
    }

    /**
     * 根据文章id删除文章、标签关系
     */
    @MethodLog(name = "根据文章id删除文章、标签关系", description = "根据文章id删除文章、标签关系")
    public int deleteRelationByInfoId(final String infoId) {
        return tagDao.deleteRelationByInfoId(infoId);
    }

    /**
     * 统计标签引用数量
     */
    @MethodLog(name = "统计标签引用数量", description = "统计标签引用数量")
    public void updateRefCount(final String tags, final String infoId) {
        if (!StringUtil.isNullOrEmpty(tags)) {
            String[] tagStr = tags.contains(",") ? tags.split(",") : new String[] { tags };
            List<String> listStr = java.util.Arrays.asList(tagStr);
            List<String> list = new ArrayList<String>(listStr);
            List<Tag> tagList = this.findByInfoId(infoId);
            for (Tag tag : tagList) {
                TagForm form = new TagForm();
                form.setId(tag.getId());
                form.setInfoId(infoId);
                if (list.contains(tag.getTagName())) {
                    list.remove(list.indexOf(tag.getTagName()));
                } else {
                    if (tag.getRefers() >= 1) {
                        tagDao.updateRefersSubtract(tag.getId());
                    }
                    this.deleteRelation(tag.getRelationId());
                }
            }
            for (String str : list) {
                TagForm form = new TagForm();
                form.setInfoId(infoId);
                form.setTagName(str);
                Tag tag = this.findByName(str);
                if (tag != null) {
                    form.setId(tag.getId());
                    tagDao.updateRefersAdd(tag.getId());
                    this.addRelation(form);
                } else {
                    form.setRefers(1);
                    this.add(form);
                    this.addRelation(form);
                }
            }
        } else {
            List<Tag> tagList = this.findByInfoId(infoId);
            for (Tag tag : tagList) {
                tagDao.updateRefersSubtract(tag.getId());
            }
            this.deleteRelationByInfoId(infoId);
        }
    }
}