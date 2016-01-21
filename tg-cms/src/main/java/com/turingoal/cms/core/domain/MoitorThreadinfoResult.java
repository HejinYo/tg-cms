package com.turingoal.cms.core.domain;

import java.util.List;
import lombok.Data;

/**
 * 线程信息
 */
@Data
public class MoitorThreadinfoResult {
    private int threadCount; // 线程总数
    private long totalStartedThreadCount; // 线程总数

    private List<MoitorThreadinfo> moitorThreadinfos;
}
