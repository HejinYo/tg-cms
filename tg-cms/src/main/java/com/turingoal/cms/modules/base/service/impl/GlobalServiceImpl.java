package com.turingoal.cms.modules.base.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.modules.base.domain.Global;
import com.turingoal.cms.modules.base.domain.form.GlobalForm;
import com.turingoal.cms.modules.base.domain.query.GlobalQuery;
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
     * 查询全部 全局参数
     */
    @MethodLog(name = "查询全部Global", description = "根据条件查询全部的全局参数，不分页")
    public List<Global> findAll(final GlobalQuery query) {
        return globalDao.find(query);
    }

    /**
     * 通过id得到一个 全局参数
     */
    @MethodLog(name = "通过id得到全局参数", description = "通过id得到一个全局参数")
    public Global get(final String id) {
        return globalDao.get(id);
    }

    /**
     * 新增 全局参数
     */
    @MethodLog(name = "新增全局参数", description = "新增一个全局参数")
    public void add(final GlobalForm form) {
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        globalDao.add(form);
    }

    /**
     * 修改 全局参数
     */
    @MethodLog(name = "修改全局参数", description = "修改一个全局参数")
    public int update(final GlobalForm form) {
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        int result = globalDao.update(form);
        List<Global> gs = findAll(new GlobalQuery());
        SystemHelper.setGlobal(gs.get(0));
        return result;
    }
}