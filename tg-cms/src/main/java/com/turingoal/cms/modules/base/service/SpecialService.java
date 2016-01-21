package com.turingoal.cms.modules.base.service;

import java.util.List;
import java.util.Map;
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.base.domain.Special;
import com.turingoal.cms.modules.base.domain.form.SpecialForm;
import com.turingoal.cms.modules.base.domain.query.SpecialQuery;

/**
 * SpecialService
 */
public interface SpecialService {

    /**
     * 查询全部 Special
     */
    List<Special> findAll(final SpecialQuery query);

    /**
     * 分页查询 Special
     */
    Page<Special> findByPage(final SpecialQuery query);

    /**
     * 通过id得到一个 Special
     */
    Special get(final String id);

    /**
     * 新增 Special
     */
    void add(final SpecialForm form, final Map<String, String> cusMap);

    /**
     * 修改 Special
     */
    int update(final SpecialForm form, final Map<String, String> cusMap);

    /**
     * 根据id删除一个 Special
     */
    int delete(final String id);

    /**
     * 启用
     */
    int enable(final String id);

    /**
     * 停用
     */
    int disable(final String id);
}