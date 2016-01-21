package com.turingoal.cms.modules.base.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * SpecialForm
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SpecialForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String modelId; // 模型
    private String typeId; // 专题类别
    private String title; // 标题
    private String metaKeywords; // 关键字
    private String metaDescription; // 描述
    private String specialTemplate; // 专题模板
    private Integer refersCount; // 文档数量
    private Integer viewsCount; // 浏览总数
    private Integer withImage; // 是否有图片
    private Integer recommend; // 是否推荐
    private String typeName; // 专题类型

    private String image;
    private String video;
}