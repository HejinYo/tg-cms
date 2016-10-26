package com.turingoal.cms.core.service;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.turingoal.common.domain.MonitorSysinfo;

/**
 * 系统信息
 */
public interface MonitorSysinfoService {

    /**
     * 系统信息
     */
    List<MonitorSysinfo> getInfo(final HttpServletRequest request);

    /**
     * 获得硬盘空间信息
     */
    Map<String, Object> getDiskInfo();

    /**
     * 获得内存信息
     */
    Map<String, Object> getMemoryInfo();
}