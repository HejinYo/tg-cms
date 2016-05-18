package com.turingoal.cms.modules.commons;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.turingoal.cms.core.domain.form.CustomFieldForm;

/**
 * 系统预定义字段
 */
@Service
public class SystemFields {
    // 文档字段
    public static final Map<String, CustomFieldForm> SYS_INFO_FIELD = new HashMap<String, CustomFieldForm>();

    static {
        /*
         * SYS_INFO_FIELD.put("source", new CustomFieldForm(1, "来源", "source", 2, 1, 1)); SYS_INFO_FIELD.put("author", new CustomFieldForm(1, "作者", "author", 2, 1, 1)); SYS_INFO_FIELD.put("smallImage", new CustomFieldForm(1, "标题图", "smallImage", 2, 1, 1)); SYS_INFO_FIELD.put("attributes", new
         * CustomFieldForm(1, "属性", "attributes", 2, 1, 1)); SYS_INFO_FIELD.put("text", new CustomFieldForm(1, "正文", "text", 2, 1, 1)); SYS_INFO_FIELD.put("nodes", new CustomFieldForm(1, "扩展栏目", "nodes", 2, 1, 1)); SYS_INFO_FIELD.put("fullTitle", new CustomFieldForm(1, "完整标题", "fullTitle", 2, 1,
         * 1)); SYS_INFO_FIELD.put("infoPath", new CustomFieldForm(1, "文件路径", "infoPath", 2, 1, 1)); SYS_INFO_FIELD.put("infoTemplate", new CustomFieldForm(1, "独立模板", "infoTemplate", 2, 1, 1)); SYS_INFO_FIELD.put("allowComment", new CustomFieldForm(1, "允许评论", "allowComment", 2, 1, 1));
         * SYS_INFO_FIELD.put("viewGroups", new CustomFieldForm(1, "浏览权限", "viewGroups", 2, 1, 1)); SYS_INFO_FIELD.put("largeImage", new CustomFieldForm(1, "正文图", "largeImage", 2, 1, 1)); SYS_INFO_FIELD.put("file", new CustomFieldForm(1, "文件", "file", 2, 1, 1)); SYS_INFO_FIELD.put("files", new
         * CustomFieldForm(1, "文件集", "files", 2, 1, 1)); SYS_INFO_FIELD.put("video", new CustomFieldForm(1, "视频", "video", 2, 1, 1)); SYS_INFO_FIELD.put("doc", new CustomFieldForm(1, "文库", "doc", 2, 1, 1)); SYS_INFO_FIELD.put("images", new CustomFieldForm(1, "图片集", "images", 2, 1, 1));
         */
        SYS_INFO_FIELD.put("infoText", new CustomFieldForm(6, "正文", "infoText", 2, 1, 2));
        SYS_INFO_FIELD.put("fullTitle", new CustomFieldForm(1, "完整标题", "fullTitle", 2, 1, 2));
        SYS_INFO_FIELD.put("infoPath", new CustomFieldForm(1, "文档路径", "infoPath", 2, 1, 2));
        SYS_INFO_FIELD.put("source", new CustomFieldForm(1, "来源", "source", 2, 1, 2));
        SYS_INFO_FIELD.put("sourceUrl", new CustomFieldForm(1, "来源url", "sourceUrl", 2, 1, 2));
        SYS_INFO_FIELD.put("author", new CustomFieldForm(1, "作者", "author", 2, 1, 2));
        SYS_INFO_FIELD.put("image", new CustomFieldForm(7, "图片上传", "image", 2, 1, 2));
        SYS_INFO_FIELD.put("allowComment", new CustomFieldForm(3, "是否允许评论", "allowComment", 2, 1, 2));
        SYS_INFO_FIELD.put("video", new CustomFieldForm(9, "视频上传", "video", 2, 1, 2));
        SYS_INFO_FIELD.put("doc", new CustomFieldForm(11, "文库上传", "doc", 2, 1, 2));
        SYS_INFO_FIELD.put("attrIds", new CustomFieldForm(12, "属性控件", "attrIds", 2, 1, 2));
    }

    // 栏目字段
    public static final Map<String, CustomFieldForm> SYS_NODE_FIELD = new HashMap<String, CustomFieldForm>();

    static {
        /*
         * SYS_NODE_FIELD.put("workflow", new CustomFieldForm(1, "审核流程", "workflow", 2, 1, 1)); SYS_NODE_FIELD.put("infoPerms", new CustomFieldForm(1, "文档权限", "infoPerms", 2, 1, 1)); SYS_NODE_FIELD.put("nodePerms", new CustomFieldForm(1, "栏目权限", "nodePerms", 2, 1, 1));
         * SYS_NODE_FIELD.put("viewGroups", new CustomFieldForm(1, "浏览权限", "viewGroups", 2, 1, 1)); SYS_NODE_FIELD.put("contriGroups", new CustomFieldForm(1, "投稿权限", "contriGroups", 2, 1, 1)); SYS_NODE_FIELD.put("commentGroups", new CustomFieldForm(1, "评论权限", "commentGroups", 2, 1, 1));
         * SYS_NODE_FIELD.put("smallImage", new CustomFieldForm(1, "标题图", "smallImage", 2, 1, 1)); SYS_NODE_FIELD.put("largeImage", new CustomFieldForm(1, "正文图", "largeImage", 2, 1, 1)); SYS_NODE_FIELD.put("text", new CustomFieldForm(1, "正文", "text", 2, 1, 1));
         */
        SYS_NODE_FIELD.put("image", new CustomFieldForm(7, "小图", "image", 2, 1, 2));
    }

    // 专题字段
    public static final Map<String, CustomFieldForm> SYS_SPECIAL_FIELD = new HashMap<String, CustomFieldForm>();

    static {
        /*
         * SYS_SPECIAL_FIELD.put("title", new CustomFieldForm(1, "标题", "title", 2, 1, 1)); SYS_SPECIAL_FIELD.put("metaKeywords", new CustomFieldForm(1, "关键词", "metaKeywords", 2, 1, 1)); SYS_SPECIAL_FIELD.put("metaDescription", new CustomFieldForm(1, "描述", "metaDescription", 2, 1, 1));
         * SYS_SPECIAL_FIELD.put("category", new CustomFieldForm(1, "类别", "category", 2, 1, 1)); SYS_SPECIAL_FIELD.put("creationDate", new CustomFieldForm(1, "创建日期", "creationDate", 2, 1, 1)); SYS_SPECIAL_FIELD.put("model", new CustomFieldForm(1, "模型", "model", 2, 1, 1));
         * SYS_SPECIAL_FIELD.put("specialTemplate", new CustomFieldForm(1, "独立模板", "specialTemplate", 2, 1, 1)); SYS_SPECIAL_FIELD.put("recommend", new CustomFieldForm(1, "推荐", "recommend", 2, 1, 1)); SYS_SPECIAL_FIELD.put("views", new CustomFieldForm(1, "浏览次数", "views", 2, 1, 1));
         * SYS_SPECIAL_FIELD.put("smallImage", new CustomFieldForm(1, "小图", "smallImage", 2, 1, 1)); SYS_SPECIAL_FIELD.put("largeImage", new CustomFieldForm(1, "大图", "largeImage", 2, 1, 1)); SYS_SPECIAL_FIELD.put("files", new CustomFieldForm(1, "文件集", "files", 2, 1, 1));
         * SYS_SPECIAL_FIELD.put("video", new CustomFieldForm(1, "视频", "video", 2, 1, 1)); SYS_SPECIAL_FIELD.put("images", new CustomFieldForm(1, "图片集", "images", 2, 1, 1));
         */
        SYS_SPECIAL_FIELD.put("image", new CustomFieldForm(7, "图片上传", "image", 2, 1, 2));
        SYS_SPECIAL_FIELD.put("video", new CustomFieldForm(9, "视频上传", "video", 2, 1, 2));
    }
}
