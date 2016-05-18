package com.turingoal.cms.modules.ext.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * 投票标记 Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class VoteMarkForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private java.util.Date createTime; // 日期
    private String voteOpentionId; // voteOpentionId
    private String userId; // 用户
    private String userIp; // IP
    private String userCookie; // Cookie
}