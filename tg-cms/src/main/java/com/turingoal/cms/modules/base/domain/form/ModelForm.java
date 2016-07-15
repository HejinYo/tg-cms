package com.turingoal.cms.modules.base.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * 模型Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ModelForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String type; // 类型(info:文档,node:栏目,home:首页;special:专题)
    private String modelName; // 名称
    private String codeNum; // 代码
    private String description; // 备注
}