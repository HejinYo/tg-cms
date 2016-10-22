package com.turingoal.cms.core.service;

import com.github.pagehelper.Page;
import com.turingoal.common.domain.LogInfo;
import com.turingoal.common.domain.query.LogInfoQuery;

/**
 * 日志信息Service
 */
public interface MonitorLogInfoService {

    /**
     * 分页查询日志信息
     */
    Page<LogInfo> findByPage(final LogInfoQuery query);

    /**
     * 分页查询操作 日志信息
     */
    Page<LogInfo> findLoginLogByPage(final LogInfoQuery query);

    /**
     * 分页查询操作 日志信息
     */
    Page<LogInfo> findOperateLogByPage(final LogInfoQuery query);
}