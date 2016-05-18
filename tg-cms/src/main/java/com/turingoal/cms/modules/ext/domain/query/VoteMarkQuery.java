package com.turingoal.cms.modules.ext.domain.query;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * 投票标记Query
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class VoteMarkQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id; // 投票标记
    private java.util.Date createTime; // 日期
    private String voteOpentionId; // voteOpentionId
    private String userId; // 用户
    private String userIp; // IP
    private String userCookie; // Cookie
}