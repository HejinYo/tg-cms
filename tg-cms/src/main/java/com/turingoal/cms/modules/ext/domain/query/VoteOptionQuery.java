package com.turingoal.cms.modules.ext.domain.query;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * 投票项表Query 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class VoteOptionQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id; // 投票项表
    private String voteId; // voteId
    private String title; // 标题
    private Integer voteCount; // 得票数
    private String description; // 描述
    private Integer sortOrder; // 排序
}