package com.turingoal.cms.modules.ext.domain.query;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * 问卷调查记录Query
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class QuestionRecordQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id; // 问卷调查记录
    private java.util.Date createTime; // 日期
    private String ip; // IP
    private String cookie; // Cookie
    private String content; // 内容
    private String userId; // userId
    private String questionId; // questionId
    private String optionId; // optionId
}