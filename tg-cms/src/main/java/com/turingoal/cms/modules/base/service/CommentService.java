package com.turingoal.cms.modules.base.service;

import java.util.List;
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.base.domain.Comment;
import com.turingoal.cms.modules.base.domain.form.CommentForm;
import com.turingoal.cms.modules.base.domain.query.CommentQuery;

/**
 * 评论Service
 */
public interface CommentService {

    /**
     * 查询全部 评论
     */
    List<Comment> findAll(final CommentQuery query);

    /**
     * 分页查询 评论
     */
    Page<Comment> findByPage(final CommentQuery query);

    /**
     * 通过id得到一个 评论
     */
    Comment get(final String id);

    /**
     * 新增 评论
     */
    void add(final CommentForm form);

    /**
     * 修改 评论
     */
    int update(final CommentForm form);

    /**
     * 根据id删除一个 评论
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
     * 屏蔽
     */
    int shieldById(final String id);

    /**
     * 推荐
     */
    int recommendById(final String id);
}