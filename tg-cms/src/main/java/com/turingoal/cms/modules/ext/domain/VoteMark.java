package com.turingoal.cms.modules.ext.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 投票标记 
 */
@Data
public class VoteMark implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id; // 投票标记
    private java.util.Date createTime; // 日期
    private Integer voteOpentionId; // voteOpentionId
    private String userId; // 用户
    private String userIp; // IP
    private String userCookie; // Cookie
}