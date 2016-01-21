package com.turingoal.cms.modules.ext.repository;

import java.util.List;
import com.turingoal.cms.modules.ext.domain.ScoreGroup;
import com.turingoal.cms.modules.ext.domain.form.ScoreGroupForm;
import com.turingoal.cms.modules.ext.domain.query.ScoreGroupQuery;

/**
 * 计分组Dao
 */
public interface ScoreGroupDao {

    /**
     * 查询 计分组
     */
    List<ScoreGroup> find(final ScoreGroupQuery query);

    /**
     * 通过id得到一个 计分组
     */
    ScoreGroup get(final String id);

    /**
     * 新增 计分组
     */
    void add(final ScoreGroupForm form);

    /**
     * 修改 计分组
     */
    int update(final ScoreGroupForm form);

    /**
     * 根据id删除一个 计分组
     */
    int delete(final String id);
}