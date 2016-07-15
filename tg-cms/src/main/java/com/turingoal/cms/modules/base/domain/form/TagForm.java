package com.turingoal.cms.modules.base.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * TagForm
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TagForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String tagName; // 名称
    private Integer refers; // 文档数量
    private String infoId;
    private String relationId;
}