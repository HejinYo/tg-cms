package com.turingoal.cms.core.domain.query;

import java.io.Serializable;
import com.turingoal.common.domain.query.BaseUserQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户Query
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserQuery extends BaseUserQuery implements Serializable {
    private static final long serialVersionUID = 1L;
}