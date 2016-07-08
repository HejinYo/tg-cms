package com.turingoal.cms.modules.base.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * 栏目Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NodeForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String parentId; // 父级栏目
    private String nodeModelId; // 栏目模型
    private String infoModelId; // 文档模型
    private String nodeTemplate; // 栏目模板
    private String infoTemplate; // 文档模板
    private String codeNum; // 代码
    private String nodeName; // 名称
    private Integer refersCount; // 文档数量
    private Integer viewsCount; // 浏览总数
    private Integer realNode = 1; // 是否真实栏目
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
    private String image;
}