package com.turingoal.cms.modules.ext.repository;

import java.util.List;
import com.turingoal.cms.modules.ext.domain.ScoreItem;
import com.turingoal.cms.modules.ext.domain.form.ScoreItemForm;
import com.turingoal.cms.modules.ext.domain.query.ScoreItemQuery;

/**
 * 计分项Dao
 */
public interface ScoreItemDao {

    /**
     * 查询 计分项
     */
    List<ScoreItem> find(final ScoreItemQuery query);

    /**
     * 通过id得到一个 计分项
     */
    ScoreItem get(final String id);

    /**
     * 新增 计分项
     */
    void add(final ScoreItemForm form);

    /**
     * 修改 计分项
     */
    int update(final ScoreItemForm form);

    /**
     * 根据id删除一个 计分项
     */
    int delete(final String id);

    /**
     * 根据计分组id获取计分选项信息
     */
    List<ScoreItem> getById(final String groupId);
}