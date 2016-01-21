package com.turingoal.cms.core.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * 用户角色关联Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserRoleForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userId;
    private String roleId;
}