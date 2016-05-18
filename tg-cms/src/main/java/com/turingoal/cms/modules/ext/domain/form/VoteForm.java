package com.turingoal.cms.modules.ext.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * 投票 Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class VoteForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title; // 标题
    private String codeNum; // 编码
    private java.util.Date startTime; // 开始日期
    private java.util.Date endTime; // 结束日期
    private Integer intervalDays; // 间隔时间（天）
    private Integer maxSelected; // 最多可选几项(0不限制)
    private Integer voteMode; // 模式(1:独立访客,2:独立IP,3:独立用户)
    private Integer totalCount; // 总票数
    private String description; // 描述
    private Integer enabled = 1; // 状态(1:启用,2:禁用)
    private Integer startDrop;
    private Integer endDrop;
    private String dropPosition;
}