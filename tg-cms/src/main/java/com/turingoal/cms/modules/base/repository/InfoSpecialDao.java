package com.turingoal.cms.modules.base.repository;

import java.util.List;
import java.util.Map;
import com.turingoal.cms.modules.base.domain.InfoSpecial;
import com.turingoal.cms.modules.base.domain.form.InfoSpecialForm;
import com.turingoal.cms.modules.base.domain.query.InfoSpecialQuery;

/**
 * InfoSpecialDao
 */
public interface InfoSpecialDao {

    /**
     * 查询 InfoSpecial
     */
    List<InfoSpecial> find(final InfoSpecialQuery query);

    /**
     * 通过id得到一个 InfoSpecial
     */
    InfoSpecial get(final String id);

    /**
     * 新增 InfoSpecial
     */
    void add(final InfoSpecialForm form);

    /**
     * 修改 InfoSpecial
     */
    int update(final InfoSpecialForm form);

    /**
     * 根据id删除一个 InfoSpecial
     */
    int delete(final String id);

    /**
     * 修改状态
     */
    int changeState(final Map<String, Object> map);

    /**
     * 根据文章id、专题id删除一个关系
     */
    int deleteRelation(final InfoSpecialForm form);
}