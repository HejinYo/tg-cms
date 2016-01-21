package com.turingoal.cms.modules.ext.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * 调查问卷Form 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class QuestionForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String codeNum; // 问卷编码
    private String title; // 标题
    private String description; // 描述
    private java.util.Date startTime; // 开始日期
    private java.util.Date endTime; // 结束日期
    private java.util.Date createTime; // 创建日期
    private Integer mode; // 模式(1:独立访客,2:独立IP,3:独立用户)
    private Integer totalCount; // 总票数
    private Integer enabled = 1; // 状态
}