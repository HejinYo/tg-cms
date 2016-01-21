package com.turingoal.cms.modules.ext.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 问卷调查记录 
 */
@Data
public class QuestionRecord implements Serializable {
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