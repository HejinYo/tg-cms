package com.turingoal.cms.core.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.turingoal.common.constants.ConstantEditableValue;
import com.turingoal.common.constants.ConstantEnabledValue;
import com.turingoal.common.constants.ConstantLockedValue;
import lombok.Data;

/**
 * 用户
 */
@Data
public class User implements UserDetails, Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 用户表
    private String username; // 用户名
    private String realname; // 真实姓名
    private String userPass; // 密码
    private String idCardNum; // 身份证号
    private Integer gender; // 性别
    private Date birthday; // 出生日期
    private String cellphoneNumber; // 手机号
    private String telephoneNumber; // 电话号码
    private String email; // 邮箱
    private Date preLoginTime; // 上次登录时间
    private String preLoginIp; // 上次登录ip
    private Date lastLoginTime; // 最后登录时间
    private String lastLoginIp; // 最后登录ip
    private Date lastLogoutTime; // 最后登出时间
    private Date accountExpireTime; // 账户过期时间
    private Date credentialsExpireTime; // 凭证过期时间
    private Integer editable = ConstantEditableValue.EDITABLE_INT; // 是否可编辑
    private Integer locked = ConstantLockedValue.UNLOCKED_INT; // 是否锁定
    private Integer userEnabled = ConstantEnabledValue.ENABLED_INT; // 是否启用
    private List<String> userPermissions; // 用户拥有的Permission

    /**
     * 解决和spring security的isEnabled的冲突
     */
    @SuppressWarnings("unused")
    private void setEnabled(final Integer enabled) {
        userEnabled = enabled;
    }

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public String getPassword() {
        return userPass;
    }

    /**
     * 账户未过期
     */
    @Override
    public boolean isAccountNonExpired() {
        if (accountExpireTime != null) {
            return accountExpireTime.after(new Date());
        } else {
            return true;
        }
    }

    /**
     * 账户没有锁定
     */
    @Override
    public boolean isAccountNonLocked() {
        return locked != ConstantLockedValue.LOCKED_INT;
    }

    /**
     * 凭证没有过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        if (credentialsExpireTime != null) {
            return credentialsExpireTime.after(new Date());
        } else {
            return true;
        }
    }

    /**
     * 账户是否启用
     */
    @Override
    public boolean isEnabled() {
        return userEnabled == ConstantEnabledValue.ENABLED_INT;
    }

    /**
     * 用来解决单一账户登录问题
     */
    @Override
    public boolean equals(Object rhs) {
        if (rhs instanceof User) {
            return username.equals(((User) rhs).username);
        }
        return false;
    }

    /**
     * 用来解决单一账户登录问题
     */
    @Override
    public int hashCode() {
        return username.hashCode();
    }
}