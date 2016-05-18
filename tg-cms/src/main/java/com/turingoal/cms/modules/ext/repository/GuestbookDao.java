package com.turingoal.cms.modules.ext.repository;

import java.util.List;
import java.util.Map;
import com.turingoal.cms.modules.ext.domain.Guestbook;
import com.turingoal.cms.modules.ext.domain.form.GuestbookForm;
import com.turingoal.cms.modules.ext.domain.query.GuestbookQuery;

/**
 * 留言板Dao
 */
public interface GuestbookDao {

    /**
     * 查询 留言板
     */
    List<Guestbook> find(final GuestbookQuery query);

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
     * 根据typeId删除留言板信息
     */
    int deleteByTypeId(final String typeId);

    /**
     * 修改留言板状态
     */
    int changeState(final Map<String, Object> map);

    /**
     * 获取留言排行
     */
    List<Guestbook> top(GuestbookQuery query);
}