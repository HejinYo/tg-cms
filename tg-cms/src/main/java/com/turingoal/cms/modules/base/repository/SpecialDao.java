package com.turingoal.cms.modules.base.repository;

import java.util.List;
import java.util.Map;
import com.turingoal.cms.modules.base.domain.Special;
import com.turingoal.cms.modules.base.domain.form.SpecialForm;
import com.turingoal.cms.modules.base.domain.query.SpecialQuery;

/**
 * SpecialDao
 */
public interface SpecialDao {

    /**
     * 查询 Special
     */
    List<Special> find(final SpecialQuery query);

    /**
     * 通过id得到一个 Special
     */
    Special get(final String id);

    /**
     * 新增 Special
     */
    void add(final SpecialForm form);

    /**
     * 修改 Special
     */
    int update(final SpecialForm form);

    /**
     * 根据id删除一个 Special
     */
    int delete(final String id);

    /**
     * 修改状态
     */
    int changeState(final Map<String, Object> map);
}