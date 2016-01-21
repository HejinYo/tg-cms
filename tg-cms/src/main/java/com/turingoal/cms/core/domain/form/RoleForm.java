package com.turingoal.cms.core.domain.form;

import java.io.Serializable;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import com.turingoal.common.bean.BaseFormBean;
import com.turingoal.common.util.validator.ValidGroupAdd;
import com.turingoal.common.util.validator.ValidGroupUpdate;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RoleForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String codeNum; // 编码
    @NotEmpty(message = "【角色名称】不能为空！", groups = { ValidGroupAdd.class })
    @Length(min = 1, max = 20, message = "【角色名称】最少1个字符，最大20个字符！", groups = { ValidGroupAdd.class, ValidGroupUpdate.class })
    private String roleName; // 角色名称
    @Length(max = 100, message = "【描述】最大长度为100个字符！", groups = { ValidGroupAdd.class, ValidGroupUpdate.class })
    private String description; // 描述
}