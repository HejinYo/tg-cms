package com.turingoal.cms.modules.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.modules.base.domain.SpecialType;
import com.turingoal.cms.modules.base.domain.form.SpecialTypeForm;
import com.turingoal.cms.modules.base.domain.query.SpecialTypeQuery;
import com.turingoal.cms.modules.base.repository.SpecialTypeDao;
import com.turingoal.cms.modules.base.service.SpecialTypeService;
import com.turingoal.common.annotation.MethodLog;
import com.turingoal.common.constants.ConstantEnabledValue;

/**
 * 专题类型 Service
 */
@Service
public class SpecialTypeServiceImpl implements SpecialTypeService {
    @Autowired
    private SpecialTypeDao specialTypeDao;

    /**
     * 查询全部 专题类型
     */
    @MethodLog(name = "查询全部专题类型", description = "根据条件查询全部的专题类型，不分页")
    public Page<SpecialType> findAll(final SpecialTypeQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        Page<SpecialType> result = (Page<SpecialType>) specialTypeDao.find(query);
        return result;
    }

    /**
     * 通过id得到一个 专题类型
     */
    @MethodLog(name = "通过id得到专题类型", description = "通过id得到一个专题类型")
    public SpecialType get(final String id) {
        return specialTypeDao.get(id);
    }

    /**
     * 新增 专题类型
     */
    @MethodLog(name = "新增专题类型", description = "新增一个专题类型，返回id")
    public void add(final SpecialTypeForm form) {
        form.setViewsCount(0);
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        specialTypeDao.add(form);
    }

    /**
     * 修改 专题类型
     */
    @MethodLog(name = "修改专题类型", description = "修改一个专题类型")
    public int update(final SpecialTypeForm form) {
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        return specialTypeDao.update(form);
    }

    /**
     * 根据id删除一个 专题类型
     */
    @MethodLog(name = "删除专题类型", description = "根据id删除一个专题类型")
    public int delete(final String id) {
        return specialTypeDao.delete(id);
    }

    /**
     * 启用
     */
    @MethodLog(name = "启用专题类型", description = "根据id启用一个专题类型")
    public void enable(final String id) {
        specialTypeDao.changeEnabled(id, ConstantEnabledValue.ENABLED_INT);
    }

    /**
     * 停用
     */
    @MethodLog(name = "停用专题类型", description = "根据id停用一个专题类型")
    public void disable(final String id) {
        specialTypeDao.changeEnabled(id, ConstantEnabledValue.DISABLED_INT);
    }
}