package com.turingoal.cms.modules.base.service;

import java.util.List;
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.base.domain.Comment;
import com.turingoal.cms.modules.base.domain.form.CommentForm;
import com.turingoal.cms.modules.base.domain.query.CommentQuery;

/**
 * CommentService
 */
public interface CommentService {

    /**
     * 查询全部 Comment
     */
    List<Comment> findAll(final CommentQuery query);

    /**
     * 分页查询 Comment
     */
    Page<Comment> findByPage(final CommentQuery query);

    /**
     * 通过id得到一个 Comment
     */
    Comment get(final String id);

    /**
     * 新增 Comment
     */
    void add(final CommentForm form);

    /**
     * 修改 Comment
     */
    int update(final CommentForm form);

    /**
     * 根据id删除一个 Comment
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