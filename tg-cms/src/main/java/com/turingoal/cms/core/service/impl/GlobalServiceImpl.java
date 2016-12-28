package com.turingoal.cms.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.core.domain.Global;
import com.turingoal.cms.core.domain.form.GlobalForm;
import com.turingoal.cms.core.repository.GlobalDao;
import com.turingoal.cms.core.service.GlobalService;
import com.turingoal.common.annotation.MethodLog;

/**
 * 全局参数Service
 */
@Service
public class GlobalServiceImpl implements GlobalService {
    @Autowired
    private GlobalDao globalDao;

    /**
     * 获取全局配置，添加到缓存
     */
    @Cacheable(value = "sys-global")
    @MethodLog(name = "获取全局配置", description = "获取全局配置")
    public Global get() {
        return globalDao.get();
    }

    /**
     * 修改 全局参数，刷新缓存
     */
    @CacheEvict(value = "sys-global")
    @MethodLog(name = "修改全局配置", description = "修改全局配置")
    public int update(final GlobalForm form) {
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        return globalDao.update(form);
    }
}