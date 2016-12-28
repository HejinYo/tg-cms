package com.turingoal.cms.core.repository;

import com.turingoal.cms.core.domain.Global;
import com.turingoal.cms.core.domain.form.GlobalForm;

/**
 * 全局配置Dao
 */
public interface GlobalDao {
    /**
     * 获取全局配置
     */
    Global get();

    /**
     * 修改 全局配置
     */
    int update(final GlobalForm form);
}