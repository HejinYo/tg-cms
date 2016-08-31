package com.turingoal.cms.core.domain.form;

import java.io.Serializable;
import java.util.Date;
import com.turingoal.common.bean.BaseFormBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 日志信息Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LogInfoForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String logType; // 类型(操作日志,登录日志)
    private String message; // 消息
    private String exception; // 异常
    private String ipAddress; // IP
    private Date eventDate; // 时间
    private String username; // 用户名
    private String userId; // 用户id
    private String ipLoc; // 登录地址
    private String clientType; // 登录客户端类型
    private String clientDesc; // 登录客户端详细
    private Integer success; // 结果

    public LogInfoForm(final UserForm user) {
        this.username = user.getUsername();
        this.userId = user.getId();
        this.ipAddress = user.getLastLoginIp();
        this.ipLoc = user.getLastLoginLoc();
        this.clientType = user.getLastLoginClientType();
        this.clientDesc = user.getLastLoginClientDesc();
    }
}