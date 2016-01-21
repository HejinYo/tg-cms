package com.turingoal.cms.modules.ext.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * 问卷项ItemForm 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class QuestionItemForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String questionId; // questionId
    private String title; // 标题
    private Integer type; // 类型 1选择 2问答
    private Integer maxSelected; // 最多可选几项(0不限制)
}