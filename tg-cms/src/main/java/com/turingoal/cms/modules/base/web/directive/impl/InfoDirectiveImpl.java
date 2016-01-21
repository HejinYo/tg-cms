package com.turingoal.cms.modules.base.web.directive.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.github.pagehelper.Page;
import com.turingoal.cms.core.service.SysSensitiveWordService;
import com.turingoal.cms.modules.base.domain.CmsDoc;
import com.turingoal.cms.modules.base.domain.CmsFile;
import com.turingoal.cms.modules.base.domain.CmsImage;
import com.turingoal.cms.modules.base.domain.CmsVideo;
import com.turingoal.cms.modules.base.domain.Info;
import com.turingoal.cms.modules.base.domain.query.InfoQuery;
import com.turingoal.cms.modules.base.service.AttrService;
import com.turingoal.cms.modules.base.service.CmsDocService;
import com.turingoal.cms.modules.base.service.CmsFileService;
import com.turingoal.cms.modules.base.service.CmsImageService;
import com.turingoal.cms.modules.base.service.CmsVideoService;
import com.turingoal.cms.modules.base.service.InfoService;
import com.turingoal.cms.modules.base.service.NodeService;
import com.turingoal.cms.modules.base.web.directive.InfoDirective;
import com.turingoal.cms.modules.commons.ConstantAuditState;
import com.turingoal.common.annotation.MethodLog;
import com.turingoal.common.bean.PageGridBean;
import com.turingoal.common.util.lang.StringUtil;

/**
 * InfoDirective
 */
@Component
public class InfoDirectiveImpl implements InfoDirective {
    @Autowired
    private InfoService infoService;
    @Autowired
    private NodeService nodeService;
    @Autowired
    private AttrService attrService;
    @Autowired
    private CmsImageService imageService;
    @Autowired
    private CmsFileService fileService;
    @Autowired
    private CmsVideoService videoService;
    @Autowired
    private CmsDocService docService;
    @Autowired
    private SysSensitiveWordService sensitiveWordService;

    /**
     * 根据node获取文章列表信息
     */
    @MethodLog(name = "根据node获取文章列表信息", description = "根据node获取文章列表信息，不分页")
    public List<Info> topByNode(final String nodeCode, final String attrCode, final Integer withImage, final Long limit) {
        InfoQuery query = new InfoQuery();
        String nodeId = nodeCode == null ? null : nodeService.getByCode(nodeCode).getId();
        query.setNodeId(nodeId);
        String attrId = attrCode == null ? null : attrService.getByCode(attrCode).getId();
        query.setAttrId(attrId);
        query.setWithImage(withImage);
        query.setLimit(limit == null ? 0L : limit);
        query.setState(ConstantAuditState.AUDIT_SUCCESS);
        query.setPublishTime(new Date());
        return infoService.findByPage(query);
    }

    /**
     * 根据tag获取文章列表信息
     */
    @MethodLog(name = "根据tag获取文章列表信息", description = "根据tag获取文章列表信息，不分页")
    public List<Info> topByTag(final String tagId, final String attrCode, final Integer withImage, final Long limit) {
        InfoQuery query = new InfoQuery();
        query.setTagId(tagId);
        String attrId = attrCode == null ? null : attrService.getByCode(attrCode).getId();
        query.setAttrId(attrId);
        query.setWithImage(withImage);
        query.setLimit(limit == null ? 1 : limit);
        query.setState(ConstantAuditState.AUDIT_SUCCESS);
        query.setPublishTime(new Date());
        return infoService.findByPage(query);
    }

    /**
     * 根据id获取一篇文章信息
     */
    @MethodLog(name = "根据id获取一篇文章信息", description = "根据id获取一篇文章信息")
    public Info getById(final String id) {
        // 屏蔽关键字
        Info info = infoService.get(id);
        info.setInfoText(sensitiveWordService.replace(info.getInfoText()));
        return info;
    }

    /**
     * 根据node分页获取文章列表信息
     */
    @MethodLog(name = "根据node分页获取文章列表信息", description = "根据node分页获取文章列表信息")
    public PageGridBean pageListByNode(final String nodeCode, final String attrCode, final Integer withImage, final Long page, final Long pageSize) {
        InfoQuery query = new InfoQuery();
        String nodeId = nodeCode == null ? null : nodeService.getByCode(nodeCode).getId();
        query.setNodeId(nodeId);
        String attrId = attrCode == null ? null : attrService.getByCode(attrCode).getId();
        query.setAttrId(attrId);
        query.setWithImage(withImage);
        query.setPage(page == null ? 1 : page);
        query.setLimit(pageSize == null ? 1 : pageSize);
        query.setState(ConstantAuditState.AUDIT_SUCCESS);
        query.setPublishTime(new Date());
        Page<Info> result = (Page<Info>) infoService.findByPage(query);
        return new PageGridBean(query, result, true);
    }

    /**
     * 根据special分页获取文章列表信息
     */
    @MethodLog(name = "根据special分页获取文章列表信息", description = "根据special分页获取文章列表信息")
    public PageGridBean pageListBySpecial(final String specialId, final String attrCode, final Integer withImage, final Long page, final Long pageSize) {
        InfoQuery query = new InfoQuery();
        query.setSpecialId(specialId);
        String attrId = attrCode == null ? null : attrService.getByCode(attrCode).getId();
        query.setAttrId(attrId);
        query.setWithImage(withImage);
        query.setState(ConstantAuditState.AUDIT_SUCCESS);
        query.setPublishTime(new Date());
        Page<Info> result = (Page<Info>) infoService.findByPage(query);
        return new PageGridBean(result.getTotal(), page, pageSize, result);
    }

    /**
     * 根据tag分页获取文章列表信息
     */
    @MethodLog(name = "根据tag分页获取文章列表信息", description = "根据tag分页获取文章列表信息")
    public PageGridBean pageListByTag(final String tagId, final String attrCode, final Integer withImage, final Long page, final Long pageSize) {
        InfoQuery query = new InfoQuery();
        query.setTagId(tagId);
        String attrId = attrCode == null ? null : attrService.getByCode(attrCode).getId();
        query.setAttrId(attrId);
        query.setWithImage(withImage);
        query.setState(ConstantAuditState.AUDIT_SUCCESS);
        query.setPublishTime(new Date());
        Page<Info> result = (Page<Info>) infoService.findByPage(query);
        return new PageGridBean(query, result, true);
    }

    /**
     * 根据id获取上一篇文章信息
     */
    @MethodLog(name = "根据id获取上一篇文章信息", description = "根据id获取上一篇文章信息")
    public Info prevOne(final String id) {
        return infoService.prevOne(id);
    }

    /**
     * 根据id获取下一篇文章信息
     */
    @MethodLog(name = "根据id获取下一篇文章信息", description = "根据id获取下一篇文章信息")
    public Info nextOne(final String id) {
        return infoService.nextOne(id);
    }

    @Override
    public String getImgById(final String id) {
        if (!StringUtil.isNullOrBlank(id)) {
            CmsImage image = imageService.get(id);
            return image != null ? image.getImgPath() : "";
        }
        return "";
    }

    @Override
    public List<String> findImgsByIds(final String id) {
        return null;
    }

    @Override
    public String getFileById(final String id) {
        if (!StringUtil.isNullOrEmpty(id)) {
            CmsFile file = fileService.get(id);
            return file != null ? file.getFilePath() : "";
        }
        return "";
    }

    @Override
    public Info getFirstByNode(final String nodeCode) {
        InfoQuery query = new InfoQuery();
        String nodeId = nodeCode == null ? null : nodeService.getByCode(nodeCode).getId();
        query.setNodeId(nodeId);
        query.setLimit(1L);
        query.setState(ConstantAuditState.AUDIT_SUCCESS);
        query.setPublishTime(new Date());
        List<Info> list = infoService.findByPage(query);
        Info info = null;
        if (list != null && list.size() > 0) {
            info = list.get(0);
            info.setInfoText(sensitiveWordService.replace(info.getInfoText()));
            infoService.updateViewsCount(info.getId());
        }
        return info;
    }

    /**
     * getVideoById
     */
    public String getVideoById(final String id) {
        if (!StringUtil.isNullOrEmpty(id)) {
            CmsVideo file = videoService.get(id);
            return file != null ? file.getVideoPath() : "";
        }
        return "";
    }

    /**
     * getDocById
     */
    public String getDocById(final String id) {
        if (!StringUtil.isNullOrEmpty(id)) {
            CmsDoc file = docService.get(id);
            return file != null ? file.getDocPath() : "";
        }
        return "";
    }
}