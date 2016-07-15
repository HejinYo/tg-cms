package com.turingoal.cms.modules.base.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * 文章属性Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class InfoAttrsForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String infoId; // 文档
    private String attributeId; // 属性
    private String image; // 属性图片
}