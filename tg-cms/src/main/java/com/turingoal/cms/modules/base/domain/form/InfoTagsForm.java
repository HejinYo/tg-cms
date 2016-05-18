package com.turingoal.cms.modules.base.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * InfoTagsForm
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class InfoTagsForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String infoId; // 文档
    private Integer tagId; // tag
    private Integer tagOrder; // tag序号
}