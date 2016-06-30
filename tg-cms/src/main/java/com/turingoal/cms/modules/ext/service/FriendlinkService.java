package com.turingoal.cms.modules.ext.service;

import java.util.List;
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.ext.domain.Friendlink;
import com.turingoal.cms.modules.ext.domain.form.FriendlinkForm;
import com.turingoal.cms.modules.ext.domain.query.FriendlinkQuery;

/**
 * 友情链接Service
 */
public interface FriendlinkService {
    /**
     * 根据类型查询友情链接
     */
    List<Friendlink> findByType(FriendlinkQuery query);

    /**
     * 查询全部 友情链接
     */
    Page<Friendlink> find(final FriendlinkQuery query);

    /**
     * 查询全部 友情链接
     */
    List<Friendlink> findEnabled(final FriendlinkQuery query);

    /**
     * 通过id得到一个 友情链接
     */
    Friendlink get(final String id);

    /**
     * 新增 友情链接
     */
    void add(final FriendlinkForm form);

    /**
     * 修改 友情链接
     */
    int update(final FriendlinkForm form);

    /**
     * 根据id删除一个 友情链接
     */
    int delete(final String id);

    /**
     * 启用
     */
    int enable(final String id);

    /**
     * 停用
     */
    int disable(final String id);

    /**
     * 推荐
     */
    int changeRecommend(final FriendlinkForm form);
}