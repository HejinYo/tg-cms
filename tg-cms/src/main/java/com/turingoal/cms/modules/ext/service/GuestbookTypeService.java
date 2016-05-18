package com.turingoal.cms.modules.ext.service;

import com.github.pagehelper.Page;
import com.turingoal.cms.modules.ext.domain.GuestbookType;
import com.turingoal.cms.modules.ext.domain.form.GuestbookTypeForm;
import com.turingoal.cms.modules.ext.domain.query.GuestbookTypeQuery;

/**
 * 留言板类型Service
 */
public interface GuestbookTypeService {

    /**
     * 查询全部 留言板类型
     */
    Page<GuestbookType> findAll(final GuestbookTypeQuery query);

    /**
     * 通过id得到一个 留言板类型
     */
    GuestbookType get(final String id);

    /**
     * 新增 留言板类型
     */
    void add(final GuestbookTypeForm form);

    /**
     * 修改 留言板类型
     */
    int update(final GuestbookTypeForm form);

    /**
     * 根据id删除一个 留言板类型
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