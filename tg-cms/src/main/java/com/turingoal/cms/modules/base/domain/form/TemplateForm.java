package com.turingoal.cms.modules.base.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * 模板Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TemplateForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String templateName; // 模板名称
    private String codeNum; // 模板代码
    private String description; // 描述
    private Integer sortOrder; // 排序
    private String contentPath;
}