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

    /**
     * 根据专题id获取最大序号
     */
    Integer getMaxOrder(final String specialId);

    /**
     * 修改序号（加1）
     */
    int updateOrderAdd(final InfoSpecialForm form);

    /**
     * 修改序号（减1）
     */
    int updateOrderSubtract(final InfoSpecialForm form);

    /**
     * 修改文章、专题关系排序（递减）
     */
    int subtractOrder(final InfoSpecialForm form);

    /**
     * 修改文章、专题关系排序（递增）
     */
    void addOrder(final InfoSpecialForm form);

    /**
     * 修改文章、专题关系排序
     */
    int updateOrder(final InfoSpecialForm form);
}