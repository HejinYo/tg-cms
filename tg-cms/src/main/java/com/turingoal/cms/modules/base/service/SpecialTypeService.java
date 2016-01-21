package com.turingoal.cms.modules.base.service;

import com.github.pagehelper.Page;
import com.turingoal.cms.modules.base.domain.SpecialType;
import com.turingoal.cms.modules.base.domain.form.SpecialTypeForm;
import com.turingoal.cms.modules.base.domain.query.SpecialTypeQuery;

/**
 * SpecialTypeService
 */
public interface SpecialTypeService {

    /**
     * 查询全部 SpecialType
     */
    Page<SpecialType> findAll(final SpecialTypeQuery query);

    /**
     * 通过id得到一个 SpecialType
     */
    SpecialType get(final String id);

    /**
     * 新增 SpecialType
     */
    void add(final SpecialTypeForm form);

    /**
     * 修改 SpecialType
     */
    int update(final SpecialTypeForm form);

    /**
     * 根据id删除一个 SpecialType
     */
    int delete(final String id);
}