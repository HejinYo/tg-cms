package com.turingoal.cms.modules.ext.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * 调差问卷项 
 */
@Data
public class QuestionItem implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id; // 调查问卷项
    private String questionId; // questionId
    private String title; // 标题
    private Integer type; // 类型 1选择 2问答
    private Integer maxSelected; // 最多可选几项(0不限制)
    private Integer sortOrder; // 排序
    
    private List<QuestionOption> questionOptions = new ArrayList<QuestionOption>();
}