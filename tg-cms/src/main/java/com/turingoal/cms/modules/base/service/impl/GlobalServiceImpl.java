package com.turingoal.cms.modules.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.modules.base.domain.Global;
import com.turingoal.cms.modules.base.domain.form.GlobalForm;
import com.turingoal.cms.modules.base.repository.GlobalDao;
import com.turingoal.cms.modules.base.service.GlobalService;
import com.turingoal.common.annotation.MethodLog;

/**
 * 全局参数Service
 */
@Service
public class GlobalServiceImpl implements GlobalService {
    @Autowired
    private GlobalDao globalDao;

    /**
     * 获取第一条数据
     */
    @MethodLog(name = "获取第一条数据", description = "获取第一条数据")
    public Global get() {
        return globalDao.get();
    }

    /**
     * 修改 全局参数
     */
    @MethodLog(name = "修改全局参数", description = "修改一个全局参数")
    public int update(final GlobalForm form) {
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        return globalDao.update(form);
    }
}