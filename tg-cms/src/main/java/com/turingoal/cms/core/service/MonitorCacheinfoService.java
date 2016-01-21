package com.turingoal.cms.core.service;

import java.util.List;
import com.turingoal.cms.core.domain.MonitorCacheinfo;

/**
 * 缓存信息
 */
public interface MonitorCacheinfoService {

    /**
     * 缓存信息
     */
    List<MonitorCacheinfo> getInfo();
}
