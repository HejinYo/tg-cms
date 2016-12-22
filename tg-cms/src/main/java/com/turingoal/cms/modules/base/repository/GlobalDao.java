package com.turingoal.cms.modules.base.repository;

import java.util.List;
import com.turingoal.cms.modules.base.domain.Global;
import com.turingoal.cms.modules.base.domain.form.GlobalForm;
import com.turingoal.cms.modules.base.domain.query.GlobalQuery;

/**
 * 全局配置Dao
 */
public interface GlobalDao {

    /**
     * 获得全局配置
     */
    List<Global> find(final GlobalQuery query);

    /**
     * 通过id得到一个 全局配置
     */
    Global get(final String id);

    /**
     * 新增全局配置
     */
    void add(final GlobalForm form);

    /**
     * 修改 全局配置
     */
    int update(final GlobalForm form);

    /**
     * 删除 全局配置
     */
    int delete(final String id);
}