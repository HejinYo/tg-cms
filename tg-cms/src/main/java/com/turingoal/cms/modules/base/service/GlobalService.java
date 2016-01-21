package com.turingoal.cms.modules.base.service;

import java.util.List;
import com.turingoal.cms.modules.base.domain.Global;
import com.turingoal.cms.modules.base.domain.form.GlobalForm;
import com.turingoal.cms.modules.base.domain.query.GlobalQuery;

/**
 * GlobalService
 */
public interface GlobalService {

    /**
     * 查询全部 Global
     */
    List<Global> findAll(final GlobalQuery query);

    /**
     * 通过id得到一个 Global
     */
    Global get(final String id);

    /**
     * 新增 Global
     */
    void add(final GlobalForm form);

    /**
     * 修改 Global
     */
    int update(final GlobalForm form);
}