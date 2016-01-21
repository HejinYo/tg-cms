package com.turingoal.cms.modules.ext.service;

import java.util.List;
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.ext.domain.Guestbook;
import com.turingoal.cms.modules.ext.domain.form.GuestbookForm;
import com.turingoal.cms.modules.ext.domain.query.GuestbookQuery;

/**
 * 留言板Service
 */
public interface GuestbookService {

    /**
     * 查询全部 留言板
     */
    List<Guestbook> findAll(final GuestbookQuery query);

    /**
     * 分页查询 留言板
     */
    Page<Guestbook> findByPage(final GuestbookQuery query);

    /**
     * 通过id得到一个 留言板
     */
    Guestbook get(final String id);

    /**
     * 新增 留言板
     */
    void add(final GuestbookForm form);

    /**
     * 修改 留言板
     */
    int update(final GuestbookForm form);

    /**
     * 根据id删除一个 留言板
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
     * 获取留言排行
     */
    List<Guestbook> top(GuestbookQuery query);
}