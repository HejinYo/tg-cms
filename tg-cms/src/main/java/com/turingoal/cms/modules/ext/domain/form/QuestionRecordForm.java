package com.turingoal.cms.modules.ext.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * 问卷调查记录Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class QuestionRecordForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private java.util.Date createTime; // 日期
    private String ip; // IP
    private String cookie; // Cookie
    private String content; // 内容
    private String userId; // userId
    private String questionId; // questionId
    private String optionId; // optionId
}