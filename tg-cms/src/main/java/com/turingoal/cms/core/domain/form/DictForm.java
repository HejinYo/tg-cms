package com.turingoal.cms.core.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * 数据字典Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DictForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String dictType; // 字典类型
    private String dictName; // 字典名称
    private String dictValue; // 字典值
    private String description; // 描述
}