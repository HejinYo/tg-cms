package com.turingoal.cms.core.commons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import com.turingoal.common.constants.ConstantLogInfoTypes;

/**
 * 系统日志帮助类
 */
public final class SystemLogHelper {
    private static Logger log = LogManager.getLogger(SystemLogHelper.class);

    private SystemLogHelper() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * 登录日志
     */
    public static void loginLog(final String username, final String message) {
        logToDb(ConstantLogInfoTypes.LOGIN_LOG, username, message);
    }

    /**
     * 操作日志
     */
    public static void log(final String message, final Object... objects) {
        logToDb(ConstantLogInfoTypes.OPERATE_LOG, SystemHelper.getCurrentUsername(), message, objects);
    }

    /**
     * 存储日志到数据库
     */
    private static void logToDb(final String logType, final String username, final String message, final Object... objects) {
        ThreadContext.put("logType", logType);
        ThreadContext.put("ipAddress", SystemHelper.getCurrentUserIp());
        ThreadContext.put("username", username);
        log.info(message, objects);
        ThreadContext.clearAll();
    }
}
