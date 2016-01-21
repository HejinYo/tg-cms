package com.turingoal.cms.modules.base.web.directive.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.base.domain.Comment;
import com.turingoal.cms.modules.base.domain.query.CommentQuery;
import com.turingoal.cms.modules.base.service.CommentService;
import com.turingoal.cms.modules.base.web.directive.CommentDirective;
import com.turingoal.common.annotation.MethodLog;
import com.turingoal.common.bean.PageGridBean;

/**
 * CommentDirective
 */
@Component
public class CommentDirectiveImpl implements CommentDirective {
    @Autowired
    private CommentService commentService;

    /**
     * 获取文章评论列表信息
     */
    @MethodLog(name = "获取文章评论列表信息", description = "根据条件获取文章评论列表信息，不分页")
    public List<Comment> listInfoComment(final String ownerId, final Integer state, final Long limit) {
        CommentQuery query = new CommentQuery();
        query.setOwnerType("infoModel");
        query.setOwnerId(ownerId);
        query.setStatus(state);
        query.setLimit(limit);
        return commentService.findAll(query);
    }

    /**
     * 获取专题评论列表信息
     */
    @MethodLog(name = "获取专题评论列表信息", description = "根据条件获取专题评论列表信息，不分页")
    public List<Comment> listSpecialComment(final String ownerId, final Integer state, final Long limit) {
        CommentQuery query = new CommentQuery();
        query.setOwnerType("specialModel");
        query.setOwnerId(ownerId);
        query.setStatus(state);
        query.setLimit(limit);
        return commentService.findAll(query);
    }

    /**
     * 分页获取文章评论列表信息
     */
    @MethodLog(name = "获取文章评论列表信息", description = "根据条件获取文章评论列表信息，分页")
    public PageGridBean pageListInfoComment(final String ownerId, final Integer state, final Long page, final Long pageSize) {
        CommentQuery query = new CommentQuery();
        query.setOwnerType("infoModel");
        query.setOwnerId(ownerId);
        query.setStatus(state);
        Page<Comment> result = (Page<Comment>) commentService.findByPage(query);
        return new PageGridBean(result.getTotal(), page, pageSize, result);
    }

    /**
     * 分页获取专题评论列表信息
     */
    @MethodLog(name = "获取专题评论列表信息", description = "根据条件获取专题评论列表信息，分页")
    public PageGridBean pageListSpecialComment(final String ownerId, final Integer state, final Long page, final Long pageSize) {
        CommentQuery query = new CommentQuery();
        query.setOwnerType("specialModel");
        query.setOwnerId(ownerId);
        query.setStatus(state);
        Page<Comment> result = (Page<Comment>) commentService.findByPage(query);
        return new PageGridBean(result.getTotal(), page, pageSize, result);
    }
}