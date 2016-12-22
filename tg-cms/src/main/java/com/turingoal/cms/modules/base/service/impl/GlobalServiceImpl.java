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
     * 获得全局参数
     */
    @MethodLog(name = "获得全局参数", description = "获得全局参数")
    public List<Global> find(final GlobalQuery query) {
        return globalDao.find(query);
    }

    /**
     * 通过id得到全局参数
     */
    @MethodLog(name = "通过id得到全局参数", description = "通过id得到一个全局参数")
    public Global get(final String id) {
        return globalDao.get(id);
    }

    /**
     * 获取第一条数据
     */
    @MethodLog(name = "获取第一条数据", description = "获取第一条数据")
    public Global getFirst() {
        return globalDao.getFirst();
    }

    /**
     * 新增全局参数
     */
    @MethodLog(name = "新增全局参数", description = "新增全局参数")
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
        return globalDao.update(form);
    }

    /**
     * 删除全局参数
     */
    @MethodLog(name = "删除全局参数", description = "删除全局参数")
    public int delete(final String id) {
        return globalDao.delete(id);
    }
}