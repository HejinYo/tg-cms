package com.turingoal.cms.modules.base.service;

import java.util.List;
import java.util.Map;
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.base.domain.Info;
import com.turingoal.cms.modules.base.domain.form.InfoForm;
import com.turingoal.cms.modules.base.domain.query.InfoQuery;

/**
 * 文章Service
 */
public interface InfoService {
    /**
     * 根据栏目编码查询文章
     */
    List<Info> findByNodeCodeNum(final String nodeCodeNum, final Long limit);

    /**
     * 分页查询 文章
     */
    Page<Info> findByPage(final InfoQuery query);

    /**
     * 分页查询未选择 文章
     */
    Page<Info> findUnInfo(final InfoQuery query);

    /**
     * 分页查询已选择文章
     */
    Page<Info> findInfo(final InfoQuery query);

    /**
     * 通过id得到一个 文章
     */
    Info get(final String id);

    /**
     * 新增 文章
     */
    void add(final InfoForm form, final Map<String, String> cusMap);

    /**
     * 修改 文章
     */
    int update(final InfoForm form, final Map<String, String> cusMap);

    /**
     * 根据id删除一个 文章
     */
    int delete(final String id);

    /**
     * 审核通过
     */
    int updatePassInfo(final String id);

    /**
     * 退稿/退回/审核通过
     */
    int updateBackInfo(final String id);

    /**
     * 根据id获取上一篇文章信息
     */
    Info prevOne(String id);

    /**
     * 根据id获取下一篇文章信息
     */
    Info nextOne(String id);

    /**
     * 根据多个id查询info
     */
    List<Info> findByIds(List<String> ids);

    /**
     * 新增 文章、专题关系
     */
    void addRelation(final InfoForm form);

    /**
     * 删除 文章、专题关系
     */
    int deleteRelation(final String id);

    /**
     * 更新浏览次数
     */
    void updateViewsCount(String id);

    /**
     * 获取所有
     */
    List<Info> findAll(InfoQuery infoQuery);
}