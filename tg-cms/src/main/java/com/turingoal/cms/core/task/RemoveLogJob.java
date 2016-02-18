package com.turingoal.cms.core.task;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;
import com.turingoal.cms.core.repository.LogInfoDao;

/**
 * 日志定时清除。@DisallowConcurrentExecution 保证多个任务间不会同时执行.所以在多任务执行时最好加上
 */
@DisallowConcurrentExecution
public class RemoveLogJob implements Job {

    private LogInfoDao logInfoDao;

    /**
     * 这里实现定时任务的方法
     */
    public void execute(final JobExecutionContext context) throws JobExecutionException {
        ApplicationContext appCtx = null;
        try {
            appCtx = (ApplicationContext) context.getScheduler().getContext().get("applicationContextKey");
        } catch (SchedulerException e1) {
            e1.printStackTrace();
        }
        if (appCtx != null) {
            logInfoDao = appCtx.getBean(LogInfoDao.class);
            logInfoDao.deleteByDate();
        }
    }
}
