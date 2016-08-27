package com.turingoal.cms.core.domain.query;

import java.io.Serializable;
import java.util.Date;
import com.turingoal.common.bean.BaseQueryBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户Query
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 用户表
    private String username; // 用户名
    private String realname; // 真实姓名
    private String userPass; // 密码
    private Date accountExpireTime; // 账户过期时间
    private Date credentialsExpireTime; // 凭证过期时间
    private Integer locked; // 是否锁定
    private Integer editable; // 是否可编辑
    private Integer enabled; // 是否可用
    private Date preLoginTime; // 上次登录时间
    private String preLoginIp; // 上次登录ip
    private Date lastLoginTime; // 最后登录时间
    private String lastLoginIp; // 最后登录ip
    private Date lastLogoutTime; // 最后登出时间
    private String domain; // 用户所属域， 前台、后台
}