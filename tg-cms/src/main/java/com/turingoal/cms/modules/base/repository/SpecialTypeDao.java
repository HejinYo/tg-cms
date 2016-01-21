package com.turingoal.cms.modules.base.repository;

import java.util.List;
import java.util.Map;
import com.turingoal.cms.modules.base.domain.SpecialType;
import com.turingoal.cms.modules.base.domain.form.SpecialTypeForm;
import com.turingoal.cms.modules.base.domain.query.SpecialTypeQuery;

/**
 * SpecialTypeDao
 */
public interface SpecialTypeDao {

    /**
     * 查询 SpecialType
     */
    List<SpecialType> find(final SpecialTypeQuery query);

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

    /**
     * 修改状态
     */
    int changeState(final Map<String, Object> map);
}