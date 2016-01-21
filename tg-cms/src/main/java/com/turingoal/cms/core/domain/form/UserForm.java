package com.turingoal.cms.core.domain.form;

import java.io.Serializable;
import java.util.Date;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import com.turingoal.common.bean.BaseFormBean;
import com.turingoal.common.util.validator.ValidGroupAdd;
import com.turingoal.common.util.validator.ValidGroupUpdate;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotEmpty(message = "【用户名】不能为空！", groups = { ValidGroupAdd.class })
    @Length(min = 5, max = 30, message = "【用户名】最少5个字符，最大30个字符！", groups = { ValidGroupAdd.class, ValidGroupUpdate.class })
    private String username; // 用户名
    @NotEmpty(message = "【 真实姓名】不能为空！", groups = { ValidGroupAdd.class })
    @Length(min = 1, max = 20, message = "【 真实姓名】最少1个字符，最大20个字符！", groups = { ValidGroupAdd.class, ValidGroupUpdate.class })
    private String realname; // 真实姓名
    private String userPass; // 密码
    private String idCardNum; // 身份证号
    private Integer gender; // 性别
    private Date birthday; // 出生日期
    private String cellphoneNumber; // 手机号
    private String telephoneNumber; // 电话号码
    @Email(message = "【邮箱】格式不正确！")
    private String email; // 邮箱
    private Date accountExpireTime; // 账户过期时间
    private Date credentialsExpireTime; // 凭证过期时间
    private Date preLoginTime; // 上次登录时间
    private String preLoginIp; // 上次登录ip
    private Date lastLoginTime; // 最后登录时间
    private String lastLoginIp; // 最后登录ip
    private Date lastLogoutTime; // 最后登出时间
}