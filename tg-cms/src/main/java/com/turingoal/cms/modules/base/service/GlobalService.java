package com.turingoal.cms.modules.base.service;

import com.turingoal.cms.modules.base.domain.Global;
import com.turingoal.cms.modules.base.domain.form.GlobalForm;

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