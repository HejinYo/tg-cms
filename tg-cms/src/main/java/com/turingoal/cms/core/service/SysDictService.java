package com.turingoal.cms.core.service;

import java.util.List;
import com.github.pagehelper.Page;
import com.turingoal.cms.core.domain.Dict;
import com.turingoal.cms.core.domain.form.DictForm;
import com.turingoal.cms.core.domain.query.DictQuery;
import com.turingoal.common.exception.BusinessException;

/**
 * DictService
 */
public interface SysDictService {

    /**
     * 根据字典类型查询启用的数据字典
     */
    List<Dict> findEnabledByType(final String dictType);

    /**
     * 分页查询数据字典
     */
    Page<Dict> findByPage(final DictQuery query);

    /**
     * ͨ根据id获得一个数据字典
     */
    Dict get(final String id);

    /**
     * 新增数据字典
     */
    void add(final DictForm form);

    /**
     * 修改数据字典
     */
    int update(final DictForm form) throws BusinessException;

    /**
     * 根据id删除数据字典
     */
    int delete(final String id) throws BusinessException;

    /**
     * 根据id启用数据字典
     */
    int enable(final String id) throws BusinessException;

    /**
     * 根据id停用数据字典
     */
    int disable(final String id) throws BusinessException;
}