package com.turingoal.cms.modules.commons;

/**
 * 评论-》审核状态
 */
public interface ConstantCommentState {
    
    int AUDIT_SUCCESS = 1;      // 通过（默认）
    int AUDIT_FAILURE = 2;      // 不通过
    int AUDIT_SHIELD = 3;         // 屏蔽
    int AUDIT_RECOMMEND = 4;      // 推荐
    int AUDIT_PENDING = 10;     // 待审核（默认）
}
