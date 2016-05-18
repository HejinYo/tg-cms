package com.turingoal.cms.modules.base.service;

import com.github.pagehelper.Page;
import com.turingoal.cms.modules.base.domain.SpecialType;
import com.turingoal.cms.modules.base.domain.form.SpecialTypeForm;
import com.turingoal.cms.modules.base.domain.query.SpecialTypeQuery;

/**
 * 专题类型Service
 */
public interface SpecialTypeService {

    /**
     * 查询全部 专题类型
     */
    Page<SpecialType> findAll(final SpecialTypeQuery query);

    /**
     * 通过id得到一个 专题类型
     */
    SpecialType get(final String id);

    /**
     * 新增 专题类型
     */
    void add(final SpecialTypeForm form);

    /**
     * 修改 专题类型
     */
    int update(final SpecialTypeForm form);

    /**
     * 根据id删除一个 专题类型
     */
    int delete(final String id);

    /**
     * 启用
     */
    void enable(final String id);

    /**
     * 停用
     */
    void disable(final String id);
}