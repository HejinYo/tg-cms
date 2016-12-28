package com.turingoal.cms.core.service;

import com.turingoal.cms.core.domain.Global;
import com.turingoal.cms.core.domain.form.GlobalForm;

/**
 * 全局参数Service
 */
public interface GlobalService {

    /**
     * 获取全局配置
     */
    Global get();

    /**
     * 修改全局配置
     */
    int update(final GlobalForm form);
}