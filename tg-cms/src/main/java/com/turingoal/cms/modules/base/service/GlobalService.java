package com.turingoal.cms.modules.base.service;

import com.turingoal.cms.modules.base.domain.Global;
import com.turingoal.cms.modules.base.domain.form.GlobalForm;

/**
 * 全局参数Service
 */
public interface GlobalService {

    /**
     * 获得全局参数
     */
    Global get();

    /**
     * 修改全局参数
     */
    int update(final GlobalForm form);
}