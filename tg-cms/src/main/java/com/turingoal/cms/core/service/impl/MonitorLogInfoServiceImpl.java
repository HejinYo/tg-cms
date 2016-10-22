package com.turingoal.cms.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.turingoal.common.domain.LogInfo;
import com.turingoal.common.domain.query.LogInfoQuery;
import com.turingoal.cms.core.repository.LogInfoDao;
import com.turingoal.cms.core.service.MonitorLogInfoService;
import com.turingoal.common.annotation.MethodLog;
import com.turingoal.common.constants.ConstantLogInfoTypes;

/**
 * 日志信息Service
 */
@Service
public class MonitorLogInfoServiceImpl implements MonitorLogInfoService {
    @Autowired
    private LogInfoDao logInfoDao;

    /**
     * 分页查询 日志信息
     */
    @MethodLog(name = "分页查询日志", description = "根据条件分页查询日志")
    public Page<LogInfo> findByPage(final LogInfoQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        return (Page<LogInfo>) logInfoDao.find(query);
    }

    /**
     * 分页查询 登录日志信息
     */
    @MethodLog(name = "分页查询登录日志", description = "根据条件分页查询登录日志")
    public Page<LogInfo> findLoginLogByPage(final LogInfoQuery query) {
        query.setLogType(ConstantLogInfoTypes.LOGIN_LOG);
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        return (Page<LogInfo>) logInfoDao.find(query);
    }

    /**
     * 分页查询 操作日志信息
     */
    @MethodLog(name = "分页查询操作日志", description = "根据条件分页查询操作日志")
    public Page<LogInfo> findOperateLogByPage(final LogInfoQuery query) {
        query.setLogType(ConstantLogInfoTypes.OPERATE_LOG);
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        return (Page<LogInfo>) logInfoDao.find(query);
    }
}