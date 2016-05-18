package com.turingoal.cms.modules.ext.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * 调查问卷
 */
@Data
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id; // 调查问卷
    private String codeNum; // 问卷编码
    private String title; // 标题
    private String description; // 描述
    private java.util.Date startTime; // 开始日期
    private java.util.Date endTime; // 结束日期
    private java.util.Date createTime; // 创建日期
    private Integer mode; // 模式(1:独立访客,2:独立IP,3:独立用户)
    private Integer totalCount; // 总票数
    private Integer enabled; // 状态

    private List<QuestionItem> questionItems = new ArrayList<QuestionItem>();
}