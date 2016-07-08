package com.turingoal.cms.modules.base.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseTreeNodeBean;

/**
 * 栏目
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Node extends BaseTreeNodeBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String parentId;
    private String nodeModelId; // 栏目模型
    private String infoModelId; // 文档模型
    private String nodeTemplate; // 栏目模板
    private String infoTemplate; // 文档模板
    private String nodeTemplateName;
    private String infoTemplateName;
    private String codeNum; // 代码
    private String nodeName; // 名称
    private Date createDataTime; // 创建时间
    private Integer refersCount; // 文档数量
    private Integer viewsCount; // 浏览总数
    private Integer realNode; // 是否真实栏目
    private Integer hidden = 2; // 是否隐藏
    private Integer htmlState; // htmlState
    private String nodeLink; // 转向链接
    private String htmlLink; // HTML页面
    private String metaKeywords; // 关键字
    private String metaDescription; // 描述
    private Integer newWindow = 2; // 是否在新窗口打开
    private Integer generateNode; // 是否生成栏目页
    private Integer generateInfo; // 是否生成文档页
    private String nodePath; // 栏目路径
    private String infoPath; // 文档路径
    private Integer staticMethod; // 静态页生成方式(1:手动生成;2:自动生成栏目页;3:自动生成文档页及栏目页;4:自动生成文档页、栏目页、父栏目页、首页)
    private Integer staticPages; // 栏目列表静态化页数
    private Integer singlePage; // 单页面栏目
    private Integer enabled; // 1
    private Integer sortOrder; // 排序
    private String image;
    private Map<String, Object> customs = new HashMap<String, Object>();
    /*
     * private String smallImage; // 小图 private String largeImage; // 大图
     */

    private boolean expanded = true; // 是否展开
}