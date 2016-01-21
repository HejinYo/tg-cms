package com.turingoal.cms.modules.commons;

/**
 * 文章-》审核状态
 */
public interface ConstantAuditState {

    int AUDIT_SUCCESS = 1;  // 通过
    int AUDIT_FAILURE = 2;  // 不通过
    int AUDIT_PENDING = 10; // 待审核（默认）
}
