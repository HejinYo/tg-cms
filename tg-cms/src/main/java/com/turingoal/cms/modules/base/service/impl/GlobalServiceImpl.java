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
     * 获得全局参数
     */
    @MethodLog(name = "通过id得到全局参数", description = "通过id得到一个全局参数")
    public Global get() {
        return globalDao.get();
    }

    /**
     * 修改 全局参数
     */
    @MethodLog(name = "修改全局参数", description = "修改一个全局参数")
    public int update(final GlobalForm form) {
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        int result = globalDao.update(form);
        Global global = get();
        SystemHelper.setGlobal(global);
        return result;
    }
}