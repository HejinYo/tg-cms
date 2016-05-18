package com.turingoal.cms.modules.ext.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * 调查问卷选项Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class QuestionOptionForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String itemId; // itemId
    private String title; // 标题
    private String inputField; // 是否输入框
    private Integer selectCount; // 得票数
}