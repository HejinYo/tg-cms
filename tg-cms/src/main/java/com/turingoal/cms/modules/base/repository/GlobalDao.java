package com.turingoal.cms.modules.base.repository;

import com.turingoal.cms.modules.base.domain.Global;
import com.turingoal.cms.modules.base.domain.form.GlobalForm;

/**
 * 全局配置Dao
 */
public interface GlobalDao {

    /**
     * 通过id得到一个 全局配置
     */
    Global get();

    /**
     * 修改 全局配置
     */
    int update(final GlobalForm form);
}