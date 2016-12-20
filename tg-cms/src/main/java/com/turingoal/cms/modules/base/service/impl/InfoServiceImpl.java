package com.turingoal.cms.modules.base.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.TextField;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.primitives.Doubles;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.core.commons.SystemLogHelper;
import com.turingoal.cms.core.domain.CustomFieldValue;
import com.turingoal.cms.core.domain.form.CustomFieldValueForm;
import com.turingoal.cms.core.domain.query.CustomFieldValueQuery;
import com.turingoal.cms.core.repository.CustomFieldValueDao;
import com.turingoal.cms.modules.base.domain.Info;
import com.turingoal.cms.modules.base.domain.Node;
import com.turingoal.cms.modules.base.domain.form.InfoAttrsForm;
import com.turingoal.cms.modules.base.domain.form.InfoForm;
import com.turingoal.cms.modules.base.domain.form.InfoSpecialForm;
import com.turingoal.cms.modules.base.domain.query.InfoQuery;
import com.turingoal.cms.modules.base.repository.InfoAttrsDao;
import com.turingoal.cms.modules.base.repository.InfoDao;
import com.turingoal.cms.modules.base.repository.InfoSpecialDao;
import com.turingoal.cms.modules.base.repository.NodeDao;
import com.turingoal.cms.modules.base.service.InfoService;
import com.turingoal.cms.modules.commons.ConstantAuditState;
import com.turingoal.common.annotation.MethodLog;
import com.turingoal.common.support.lucene.LuceneHelper;
import com.turingoal.common.util.lang.StringUtil;

/**
 * InfoService
 */
@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    private InfoDao infoDao;
    @Autowired
    private NodeDao nodeDao;
    @Autowired
    private CustomFieldValueDao customFieldValueDao;
    @Autowired
    private TagServiceImpl tagServiceImpl;
    /*
     * @Autowired private LuceneHelper luceneHelper;
     */
    @Autowired
    private InfoAttrsDao infoAttrsDao;
    @Autowired
    private InfoSpecialDao infoSpecialDao;

    /**
     * 根据栏目编码查询文章
     */
    @MethodLog(name = "根据栏目编码分页查询文章", description = "根据栏目编码分页查询文章")
    public List<Info> findByNodeCodeNum(final String parentCodeNum, final Long limit) {
        List<Info> result = infoDao.findByNodeCodeNum(parentCodeNum, limit);
        return result;
    }

    /**
     * 分页查询 文章
     */
    @MethodLog(name = "分页查询文章", description = "根据条件分页查询文章")
    public Page<Info> findByPage(final InfoQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        List<Info> list = infoDao.find(query);
        for (Info info : list) {
            putCustomDatas(info);
        }
        return (Page<Info>) list;
    }

    /**
     * 通过id得到一个 文章
     */
    @MethodLog(name = "通过id得到文章", description = "通过id得到一个文章")
    public Info get(final String id) {
        Info info = infoDao.get(id);
        putCustomDatas(info);
        return info;
    }

    /**
     * 设置自定义字段
     */
    private void putCustomDatas(final Info info) {
        if (info == null) {
            return;
        }
        CustomFieldValueQuery query = new CustomFieldValueQuery();
        query.setOwnerType("infoModel");
        query.setOwnerId(info.getId());
        List<CustomFieldValue> list = customFieldValueDao.findByOwner(query);
        for (CustomFieldValue fieldValue : list) {
            String keyStr = fieldValue.getKeyStr();
            String prefix = keyStr.substring(0, keyStr.lastIndexOf("_") + 1);
            String key = keyStr.replace(prefix, "");
            switch (prefix) {
            case "cus_str_":
                info.getCustoms().put(key, fieldValue.getValueStr());
                break;
            case "cus_blob_":
                info.getCustoms().put(key, fieldValue.getValueForLongText());
                break;
            case "cus_date_":
                info.getCustoms().put(key, fieldValue.getValueForDate());
                break;
            case "cus_num_":
                info.getCustoms().put(key, fieldValue.getValueForDouble());
                break;
            default:
                break;
            }
        }
    }

    /**
     * 根据tagId获取 文章
     */
    @MethodLog(name = "根据tagId获取 文章", description = "根据tagId获取 文章")
    public List<Info> findByTagId(final String tagId) {
        return infoDao.findByTagId(tagId);
    }

    /**
     * 更新自定义字段值
     */
    private void updateCusFieldValue(final InfoForm form, final Map<String, String> cusMap) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("ownerType", "infoModel");
        params.put("ownerId", form.getId());
        customFieldValueDao.deleteByModel(params);

        for (String keyStr : cusMap.keySet()) {
            CustomFieldValueForm cusForm = new CustomFieldValueForm();
            String prefix = keyStr.substring(0, keyStr.lastIndexOf("_") + 1);
            cusForm.setKeyStr(keyStr);
            switch (prefix) {
            case "cus_str_":
                cusForm.setValueStr(cusMap.get(keyStr));
                break;
            case "cus_blob_":
                cusForm.setValueForLongText(cusMap.get(keyStr));
                break;
            case "cus_date_":
                cusForm.setValueForDate(DateTime.parse(cusMap.get(keyStr).toString()).toDate());
                break;
            case "cus_num_":
                cusForm.setValueForDouble(Doubles.tryParse(cusMap.get(keyStr).toString()));
                break;
            default:
                break;
            }
            cusForm.setOwnerId(form.getId());
            cusForm.setOwnerType("infoModel");
            cusForm.setCreateDataUsername(SystemHelper.getCurrentUsername());
            customFieldValueDao.add(cusForm);
        }
    }

    /**
     * 全文检索数据
     */
    private Document fullDoc(final InfoForm info) {
        Document doc = new Document();
        Node node = nodeDao.get(info.getNodeId());
        String id = String.valueOf(info.getId());
        doc.add(new TextField("id", id, Store.YES));
        if (node != null) {
            doc.add(new TextField("nodeId", String.valueOf(node.getId()), Store.YES));
            doc.add(new TextField("codeNum", node.getCodeNum(), Store.YES));
        }
        if (StringUtils.isNotBlank(info.getTitle())) {
            doc.add(new TextField("title", info.getTitle(), Store.YES));
        }
        if (StringUtils.isNotBlank(info.getInfoText())) {
            doc.add(new TextField("infoText", info.getInfoText(), Store.YES));
        }
        if (info.getImage() != null) {
            doc.add(new TextField("image", String.valueOf(info.getImage()), Store.YES));
        }
        if (StringUtils.isNotBlank(info.getMetaKeywords())) {
            doc.add(new TextField("metaKeywords", info.getMetaKeywords(), Store.YES));
        }
        if (StringUtils.isNotBlank(info.getMetaDescription())) {
            doc.add(new TextField("metaDescription", info.getMetaDescription(), Store.YES));
        }
        return doc;
    }

    /**
     * 添加属性图片
     */
    private void addAttrImage(final InfoForm form) {
        String[] attrIds = StringUtil.isNullOrEmpty(form.getAttrIds()) ? new String[0] : form.getAttrIds().split(",");
        for (int i = 0; i < attrIds.length; i++) {
            if (!StringUtil.isNullOrEmpty(attrIds[i])) {
                String[] imageIds = form.getImageIds().split(",");
                InfoAttrsForm infoAttrs = new InfoAttrsForm();
                infoAttrs.setInfoId(form.getId());
                infoAttrs.setImage(imageIds[i]);
                infoAttrs.setAttributeId(attrIds[i]);
                infoAttrsDao.add(infoAttrs);
            }
        }
    }

    /**
     * 新增 文章
     */
    @MethodLog(name = "新增文章", description = "新增一个文章")
    public void add(final InfoForm form, final Map<String, String> cusMap) {
        form.setState(ConstantAuditState.AUDIT_SUCCESS); // AUDIT_PENDING
        form.setTitleStrong(form.getTitleStrong() == null ? 2 : 1);
        form.setTitleEm(form.getTitleEm() == null ? 2 : 1);
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        infoDao.add(form);
        updateCusFieldValue(form, cusMap);
        // luceneHelper.addIndex(fullDoc(form));
        addAttrImage(form);
        tagServiceImpl.updateRefCount(form.getMetaKeywords(), form.getId());
        // 操作日志
        SystemLogHelper.log("新增文章,id={},title={}", form.getId(), form.getTitle());
    }

    /**
     * 修改属性图片
     */
    private void updateAttrImage(final InfoForm form) {
        String[] attrIds = StringUtil.isNullOrEmpty(form.getAttrIds()) ? new String[0] : form.getAttrIds().split(",");

        infoAttrsDao.deleteByInfoId(form.getId());
        for (int i = 0; i < attrIds.length; i++) {
            // String[] imageIds = StringUtil.isNullOrEmpty(form.getImageIds()) ? new String[0] : form.getImageIds().split(",");
            if (!StringUtil.isNullOrEmpty(attrIds[i])) {
                InfoAttrsForm infoAttrs = new InfoAttrsForm();
                infoAttrs.setInfoId(form.getId());
                infoAttrs.setAttributeId(attrIds[i]);
                // infoAttrs.setImage(imageIds[i]);
                infoAttrsDao.add(infoAttrs);
            }
        }
    }

    /**
     * 修改 文章
     */
    @MethodLog(name = "修改文章", description = "修改一个文章")
    public int update(final InfoForm form, final Map<String, String> cusMap) {
        // 修改文章，状态改为待审核
        form.setState(ConstantAuditState.AUDIT_SUCCESS);
        form.setLastUpdateTime(new Date());
        form.setTitleStrong(form.getTitleStrong() == null ? 2 : 1);
        form.setTitleEm(form.getTitleEm() == null ? 2 : 1);
        if (form.getPublishTime() == null) {
            form.setPublishTime(new Date());
        }
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        int result = infoDao.update(form);
        updateCusFieldValue(form, cusMap);
        // luceneHelper.updateIndex(String.valueOf(form.getId()), fullDoc(form));
        updateAttrImage(form);
        tagServiceImpl.updateRefCount(form.getMetaKeywords(), form.getId());
        // 操作日志
        SystemLogHelper.log("修改文章,id={},title={}", form.getId(), form.getTitle());
        return result;
    }

    /**
     * 根据id删除一个 文章
     */
    @MethodLog(name = "删除文章", description = "根据id删除一个文章")
    public int delete(final String id) {
        tagServiceImpl.updateRefCount(null, id);
        int result = infoDao.delete(id);
        // 操作日志
        SystemLogHelper.log("删除文章,id={}", id);
        return result;
    }

    /**
     * 审核通过
     */
    @MethodLog(name = "审核通过文章", description = "审核通过一个文章")
    public int updatePassInfo(final String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("state", 1);
        return infoDao.changeState(params);
    }

    /**
     * 退稿/退回/审核通过
     */
    @MethodLog(name = "退稿/退回/审核通过文章", description = "退稿/退回/审核通过文章")
    public int updateBackInfo(final String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("state", 2);
        return infoDao.changeState(params);
    }

    /**
     * 根据id获取上一篇文章信息
     */
    @MethodLog(name = "根据id获取上一篇文章信息", description = "根据id获取上一篇文章信息")
    public Info prevOne(final String id) {
        return infoDao.prevOne(id);
    }

    /**
     * 根据id获取下一篇文章信息
     */
    @MethodLog(name = "根据id获取下一篇文章信息", description = "根据id获取下一篇文章信息")
    public Info nextOne(final String id) {
        return infoDao.nextOne(id);
    }

    /**
     * 修改文章关键字信息
     */
    public int updateMetaKeywords(final InfoForm form) {
        return infoDao.updateMetaKeywords(form);
    }

    @Override
    public List<Info> findByIds(final List<String> ids) {
        if (ids == null || ids.size() == 0) {
            return new ArrayList<Info>();
        }
        return infoDao.findByIds(ids);
    }

    @Override
    public void updateViewsCount(final String id) {
        InfoQuery query = new InfoQuery();
        query.setId(id);
        infoDao.updateViewsCount(query);
    }

    /**
     * 分页查询未选择 文章
     */
    @MethodLog(name = "分页查询未选择文章", description = "根据条件分页查询未选择文章")
    public Page<Info> findUnInfo(final InfoQuery query) {
        List<String> ids = infoDao.findIds(query);
        if (ids != null && ids.size() > 0) {
            query.setIds(ids.toArray());
        }
        PageHelper.startPage(query.getPage().intValue(), 10);
        List<Info> info = infoDao.findUnInfoByPage(query);
        return (Page<Info>) info;
    }

    /**
     * 分页查询已选择 文章
     */
    @MethodLog(name = "分页查询已选择文章", description = "根据条件分页查询已选择文章")
    public Page<Info> findInfo(final InfoQuery query) {
        PageHelper.startPage(query.getPage().intValue(), 10);
        List<Info> list = infoDao.findInfoByPage(query);
        return (Page<Info>) list;
    }

    /**
     * 新增 文章、专题关系
     */
    @MethodLog(name = "新增 文章、专题关系", description = "新增 文章、专题关系")
    public void addRelation(final InfoForm form) {
        InfoSpecialForm infoSpecialForm = new InfoSpecialForm();
        infoSpecialForm.setCreateDataUsername(SystemHelper.getCurrentUsername());
        infoSpecialForm.setInfoId(form.getId());
        infoSpecialForm.setSpecialId(form.getSpecialId());
        infoSpecialDao.add(infoSpecialForm);
    }

    /**
     * 删除 文章、专题关系
     */
    @MethodLog(name = "删除 文章、专题关系", description = "删除 文章、专题关系")
    public int deleteRelation(final String id) {
        return infoSpecialDao.delete(id);
    }

    @Override
    public List<Info> findAll(final InfoQuery query) {
        return infoDao.find(query);
    }
}