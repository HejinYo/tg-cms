package com.turingoal.cms.modules.ext.service;

import java.util.List;
import com.turingoal.cms.modules.ext.domain.ScoreGroup;
import com.turingoal.cms.modules.ext.domain.ScoreItem;
import com.turingoal.cms.modules.ext.domain.form.ScoreGroupForm;
import com.turingoal.cms.modules.ext.domain.form.ScoreItemForm;
import com.turingoal.cms.modules.ext.domain.query.ScoreGroupQuery;

/**
 * 计分组Service
 */
public interface ScoreGroupService {

    /**
     * 查询全部 计分组
     */
    List<ScoreGroup> findAll(final ScoreGroupQuery query);

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

    /**
     * 根据计分组id获取计分选项信息
     */
    List<ScoreItem> findItem(final String groupId);

    /**
     * 新增计分组选项信息
     */
    void addItem(final ScoreItemForm form);

    /**
     * 根据id获取计分组选项信息
     */
    ScoreItem getItem(final String id);

    /**
     * 修改计分组选项 信息
     */
    void update(final ScoreItemForm form);

    /**
     * 根据id删除一条计分组选项信息
     */
    void deleteItem(final String id);
}