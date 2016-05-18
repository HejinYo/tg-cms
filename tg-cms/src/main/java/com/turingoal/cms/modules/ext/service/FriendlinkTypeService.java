package com.turingoal.cms.modules.ext.service;

import com.github.pagehelper.Page;
import com.turingoal.cms.modules.ext.domain.FriendlinkType;
import com.turingoal.cms.modules.ext.domain.form.FriendlinkTypeForm;
import com.turingoal.cms.modules.ext.domain.query.FriendlinkTypeQuery;

/**
 * 友情链接类型Service
 */
public interface FriendlinkTypeService {

    /**
     * 查询全部 友情链接类型
     */
    Page<FriendlinkType> findAll(final FriendlinkTypeQuery query);

    /**
     * 通过id得到一个 友情链接类型
     */
    FriendlinkType get(final String id);

    /**
     * 新增 友情链接类型
     */
    void add(final FriendlinkTypeForm form);

    /**
     * 修改 友情链接类型
     */
    int update(final FriendlinkTypeForm form);

    /**
     * 根据id删除一个 友情链接类型
     */
    int delete(final String id);

    /**
     * 启用
     */
    void enable(final String id);

    /**
     * 停用
     */
    void disable(final String id);
}