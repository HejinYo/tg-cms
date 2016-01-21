package com.turingoal.cms.modules.ext.domain.query;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * 调查问卷项Query 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class QuestionItemQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id; // 调查问卷项
    private String questionId; // questionId
    private String title; // 标题
    private Integer type; // 类型 1选择 2问答
    private Integer maxSelected; // 最多可选几项(0不限制)
    private Integer sortOrder; // 排序
}