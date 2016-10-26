package com.turingoal.cms.core.domain.form;

import java.io.Serializable;
import com.turingoal.common.domain.form.BaseUserForm;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserForm extends BaseUserForm implements Serializable {
    private static final long serialVersionUID = 1L;
    private String domain = "default"; // 用户所属域， 前台、后台
}