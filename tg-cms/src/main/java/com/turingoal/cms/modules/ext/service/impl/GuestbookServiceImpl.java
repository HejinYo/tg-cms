package com.turingoal.cms.modules.ext.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.modules.ext.domain.Guestbook;
import com.turingoal.cms.modules.ext.domain.form.GuestbookForm;
import com.turingoal.cms.modules.ext.domain.query.GuestbookQuery;
import com.turingoal.cms.modules.ext.repository.GuestbookDao;
import com.turingoal.cms.modules.ext.service.GuestbookService;
import com.turingoal.common.annotation.MethodLog;

/**
 * 留言板Service
 */
@Service
public class GuestbookServiceImpl implements GuestbookService {
    @Autowired
    private GuestbookDao guestbookDao;

    /**
     * 查询全部 留言板
     */
    @MethodLog(name = "查询全部留言板", description = "根据条件查询全部的留言板，不分页")
    public List<Guestbook> findAll(final GuestbookQuery query) {
        return guestbookDao.find(query);
    }

    /**
     * 分页查询 留言板
     */
    @MethodLog(name = "分页查询留言板", description = "根据条件分页查询留言板")
    public Page<Guestbook> findByPage(final GuestbookQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        return (Page<Guestbook>) guestbookDao.find(query);
    }

    /**
     * 通过id得到一个 留言板
     */
    @MethodLog(name = "通过id得到留言板", description = "通过id得到一个留言板")
    public Guestbook get(final String id) {
        return guestbookDao.get(id);
    }

    /**
     * 新增 留言板
     */
    @MethodLog(name = "新增留言板", description = "新增一个留言板，返回id")
    public void add(final GuestbookForm form) {
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        guestbookDao.add(form);
    }

    /**
     * 修改 留言板
     */
    @MethodLog(name = "修改留言板", description = "修改一个留言板")
    public int update(final GuestbookForm form) {
        form.setReplyed(1);
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        form.setReplyerId(SystemHelper.getCurrentUser().getId());
        return guestbookDao.update(form);
    }

    /**
     * 根据id删除一个 留言板
     */
    @MethodLog(name = "删除留言板", description = "根据id删除一个留言板")
    public int delete(final String id) {
        return guestbookDao.delete(id);
    }

    /**
     * 启用
     */
    @MethodLog(name = "启用留言板", description = "根据id启用一个留言板")
    public int enable(final String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("state", 1);
        return guestbookDao.changeState(params);
    }

    /**
     * 停用
     */
    @MethodLog(name = "停用留言板", description = "根据id停用一个留言板")
    public int disable(final String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("state", 2);
        return guestbookDao.changeState(params);
    }

    /**
     * 获取留言排行
     */
    @MethodLog(name = "获取留言排行", description = "获取留言排行")
    public List<Guestbook> top(final GuestbookQuery query) {
        return guestbookDao.top(query);
    }
}