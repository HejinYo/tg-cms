package com.turingoal.cms.core.service.impl;

import java.util.ArrayList;
import java.util.List;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.turingoal.cms.core.domain.MonitorCacheinfo;
import com.turingoal.cms.core.service.MonitorCacheinfoService;

/**
 * 缓存信息
 */
@Service
public class MonitorCacheinfoServiceImpl implements MonitorCacheinfoService {

    @Autowired
    private CacheManager cacheManager;

    /**
     * 缓存信息
     */
    public List<MonitorCacheinfo> getInfo() {
        List<MonitorCacheinfo> list = new ArrayList<MonitorCacheinfo>();
        String[] cacheNames = cacheManager.getCacheNames();
        int length = cacheNames.length;
        for (int i = 0; i < length; i++) {
            String cacheName = cacheNames[i];
            Cache cache = cacheManager.getCache(cacheName);
            MonitorCacheinfo moitorCacheinfo = new MonitorCacheinfo();
            moitorCacheinfo.setName(cacheName);
            long cacheHitCount = cache.getStatistics().cacheHitCount(); // 命中次数
            long cacheMissCount = cache.getStatistics().cacheMissCount(); // 失效次数
            long totalCount = cacheHitCount + cacheMissCount; //
            long cacheHitPercent = 100;
            if (totalCount != 0) {
                cacheHitPercent = cacheHitCount * 100 / totalCount; // 总命中率
            }
            moitorCacheinfo.setTotalCount(totalCount);
            moitorCacheinfo.setCacheHits(cacheHitCount);
            moitorCacheinfo.setCacheMisses(cacheMissCount);
            moitorCacheinfo.setCacheHitPercent(cacheHitPercent + " %");
            list.add(moitorCacheinfo);
        }
        return list;
    }
}
