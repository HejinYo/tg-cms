package com.turingoal.cms.core.domain;

import lombok.Data;

/**
 * 缓存信息
 */
@Data
public class MonitorCacheinfo {
    private String name; // 名称
    private Long totalCount; // 
    private String cacheHitPercent;
    private Long cacheHits; //命中次数
    private Long cacheMisses; //失效次数
    private Long objectCount;
    private String searchesPerSecond;
    private String averageSearchTime;
    private String averageGetTime;
}
