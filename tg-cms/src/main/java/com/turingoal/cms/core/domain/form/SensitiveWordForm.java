package com.turingoal.cms.core.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * 敏感词Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SensitiveWordForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String word; // 敏感词
    private String replacement = "*"; // 替换词
}