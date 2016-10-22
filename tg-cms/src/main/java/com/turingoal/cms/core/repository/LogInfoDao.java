package com.turingoal.cms.core.repository;

import java.util.List;
import com.turingoal.common.domain.LogInfo;
import com.turingoal.common.domain.form.LogInfoForm;
import com.turingoal.common.domain.query.LogInfoQuery;

/**
 * 日志信息Dao
 */
public interface LogInfoDao {
    /**
     * 新增日志
     */
    void add(final LogInfoForm log);

    /**
     * 查询 日志信息
     */
    List<LogInfo> find(final LogInfoQuery query);

    /**
     * 根据时间定时删除系统日志
     */
    int deleteByDate();
}