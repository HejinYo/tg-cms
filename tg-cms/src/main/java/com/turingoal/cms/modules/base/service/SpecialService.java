package com.turingoal.cms.modules.base.service;

import java.util.List;
import java.util.Map;
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.base.domain.Special;
import com.turingoal.cms.modules.base.domain.form.SpecialForm;
import com.turingoal.cms.modules.base.domain.query.SpecialQuery;

/**
 * 专题Service
 */
public interface SpecialService {

    /**
     * 查询全部 专题
     */
    List<Special> findAll(final SpecialQuery query);

    /**
     * 分页查询 专题
     */
    Page<Special> findByPage(final SpecialQuery query);

    /**
     * 通过id得到一个 专题
     */
    Special get(final String id);

    /**
     * 新增 专题
     */
    void add(final SpecialForm form, final Map<String, String> cusMap);

    /**
     * 修改 专题
     */
    int update(final SpecialForm form, final Map<String, String> cusMap);

    /**
     * 根据id删除一个 专题
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