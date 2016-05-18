package com.turingoal.cms.modules.base.repository;

import java.util.List;
import java.util.Map;
import com.turingoal.cms.modules.base.domain.Info;
import com.turingoal.cms.modules.base.domain.form.InfoForm;
import com.turingoal.cms.modules.base.domain.query.InfoQuery;

/**
 * InfoDao
 */
public interface InfoDao {

    /**
     * 查询 Info
     */
    List<Info> find(final InfoQuery query);

    /**
     * 通过id得到一个 Info
     */
    Info get(final String id);

    /**
     * 根据tagId获取 Info
     */
    List<Info> findByTagId(final String tagId);

    /**
     * 新增 Info
     */
    void add(final InfoForm form);

    /**
     * 修改 Info
     */
    int update(final InfoForm form);

    /**
     * 根据id删除一个 Info
     */
    int delete(final String id);

    /**
     * 修改状态
     */
    int changeState(final Map<String, Object> map);

    /**
     * 根据id获取上一篇文章信息
     */
    Info prevOne(String id);

    /**
     * 根据id获取下一篇文章信息
     */
    Info nextOne(String id);

    /**
     * 修改文章关键字信息
     */
    int updateMetaKeywords(InfoForm form);

    /**
     * 根据多个id查询info
     */
    List<Info> findByIds(List<String> ids);

    /**
     * 更新文章浏览次数
     */
    Integer updateViewsCount(InfoQuery query);

    /**
     * 根据专题id获取所有文章id
     */
    List<String> findIds(final InfoQuery query);

    /**
     * 分页查询未选择 Info
     */
    List<Info> findUnInfoByPage(final InfoQuery query);

    /**
     * 分页查询已选择 Info
     */
    List<Info> findInfoByPage(final InfoQuery query);

}