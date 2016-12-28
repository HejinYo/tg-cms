package com.turingoal.cms.core.service;

import com.turingoal.cms.core.domain.Global;
import com.turingoal.cms.core.domain.form.GlobalForm;

/**
 * 全局参数Service
 */
public interface GlobalService {

    /**
     * 获取第一条数据
     */
    Global get();

    /**
     * 修改 全局配置
     */
    int update(final GlobalForm form);

}