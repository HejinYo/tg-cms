package com.turingoal.cms.core.domain.form;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

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
}