package com.turingoal.cms.modules.base.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * SpecialTypeForm
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SpecialTypeForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String typeName; // 名称
    private Integer viewsCount; // 浏览总数
    private String metaKeywords; // 关键字
    private String metaDescription; // 描述
}