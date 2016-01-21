package com.turingoal.cms.core.service.impl;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.turingoal.cms.core.domain.MoitorThreadinfo;
import com.turingoal.cms.core.domain.MoitorThreadinfoResult;
import com.turingoal.cms.core.service.MonitorThreadService;

/**
 * 线程信息
 */
@Service
public class MonitorThreadServiceImpl implements MonitorThreadService {

    /**
     * 线程信息
     */
    public MoitorThreadinfoResult getInfo() {
        MoitorThreadinfoResult result = new MoitorThreadinfoResult();
        List<MoitorThreadinfo> list = new ArrayList<MoitorThreadinfo>();
        ThreadMXBean tm = ManagementFactory.getThreadMXBean();
        tm.setThreadContentionMonitoringEnabled(true);
        result.setThreadCount(tm.getThreadCount()); // 线程总数
        result.setTotalStartedThreadCount(tm.getTotalStartedThreadCount()); // 线程总数
        long[] tid = tm.getAllThreadIds();
        ThreadInfo[] threadInfos = tm.getThreadInfo(tid, Integer.MAX_VALUE);
        for (int i = 0, length = threadInfos.length; i < length; i++) {
            long threadId = threadInfos[i].getThreadId();
            long cpuTime = tm.getThreadCpuTime(threadId) / 1000;
            MoitorThreadinfo moitorThreadinfo = new MoitorThreadinfo();
            moitorThreadinfo.setId(threadId);
            moitorThreadinfo.setName(threadInfos[i].getThreadName());
            moitorThreadinfo.setState(threadInfos[i].getThreadState().toString());
            moitorThreadinfo.setLockName(threadInfos[i].getLockName());
            moitorThreadinfo.setLockOwnerName(threadInfos[i].getLockOwnerName());
            moitorThreadinfo.setCpuTime(cpuTime);
            list.add(moitorThreadinfo);
        }
        result.setMoitorThreadinfos(list);
        return result;
    }
}
