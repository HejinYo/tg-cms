package com.turingoal.cms.modules.base.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.modules.base.domain.Comment;
import com.turingoal.cms.modules.base.domain.form.CommentForm;
import com.turingoal.cms.modules.base.domain.query.CommentQuery;
import com.turingoal.cms.modules.base.repository.CommentDao;
import com.turingoal.cms.modules.base.service.CommentService;
import com.turingoal.common.annotation.MethodLog;

/**
 * 评论Service
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    /**
     * 查询全部 评论
     */
    @MethodLog(name = "查询全部评论", description = "根据条件查询全部的评论，不分页")
    public List<Comment> findAll(final CommentQuery query) {
        return commentDao.find(query);
    }

    /**
     * 分页查询 评论
     */
    @MethodLog(name = "分页查询评论", description = "根据条件分页查询评论")
    public Page<Comment> findByPage(final CommentQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        return (Page<Comment>) commentDao.find(query);
    }

    /**
     * 通过id得到一个 评论
     */
    @MethodLog(name = "通过id得到评论", description = "通过id得到一个评论")
    public Comment get(final String id) {
        return commentDao.get(id);
    }

    /**
     * 新增 评论
     */
    @MethodLog(name = "新增评论", description = "新增一个评论")
    public void add(final CommentForm form) {
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        commentDao.add(form);
    }

    /**
     * 修改 评论
     */
    @MethodLog(name = "修改评论", description = "修改一个评论")
    public int update(final CommentForm form) {
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        return commentDao.update(form);
    }

    /**
     * 根据id删除一个 评论
     */
    @MethodLog(name = "删除评论", description = "根据id删除一个评论")
    public int delete(final String id) {
        return commentDao.delete(id);
    }

    /**
     * 启用
     */
    @MethodLog(name = "启用评论", description = "根据id启用一个评论")
    public int enable(final String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("state", 1);
        return commentDao.changeState(params);
    }

    /**
     * 停用
     */
    @MethodLog(name = "停用评论", description = "根据id停用一个评论")
    public int disable(final String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("state", 2);
        return commentDao.changeState(params);
    }

    /**
     * 屏蔽
     */
    @MethodLog(name = "屏蔽评论", description = "根据id屏蔽一个评论")
    public int shieldById(final String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("state", 3);
        return commentDao.changeState(params);
    }

    /**
     * 推荐
     */
    @MethodLog(name = "推荐评论", description = "根据id推荐一个评论")
    public int recommendById(final String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("state", 4);
        return commentDao.changeState(params);
    }
}