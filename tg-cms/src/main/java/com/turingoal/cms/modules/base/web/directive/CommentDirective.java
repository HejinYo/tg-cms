package com.turingoal.cms.modules.base.web.directive;

import java.util.List;
import com.turingoal.cms.modules.base.domain.Comment;
import com.turingoal.common.bean.PageGridBean;

/**
 * CommentDirective
 */
public interface CommentDirective {

    /**
     * 获取文章评论列表信息
     * 
     * @param ownerId
     *            文章id
     * @param state
     *            评论状态
     * @param limit
     *            显示条数
     * @return 返回文章评论列表
     */
    List<Comment> listInfoComment(final String ownerId, final Integer state, final Long limit);

    /**
     * 获取专题评论列表信息
     * 
     * @param ownerId
     *            专题id
     * @param state
     *            评论状态
     * @param limit
     *            显示条数
     * @return 返回专题评论列表
     */
    List<Comment> listSpecialComment(final String ownerId, final Integer state, final Long limit);

    /**
     * 分页获取文章评论列表信息
     * 
     * @param ownerId
     *            文章id
     * @param state
     *            评论状态
     * @param page
     *            当前页
     * @param pageSize
     *            每页显示条数
     * @return 返回分页文章评论信息集
     */
    PageGridBean pageListInfoComment(final String ownerId, final Integer state, final Long page, final Long pageSize);

    /**
     * 分页获取专题评论列表信息
     * 
     * @param ownerId
     *            专题id
     * @param state
     *            评论状态
     * @param page
     *            当前页
     * @param pageSize
     *            每页显示条数
     * @return 返回分页专题评论信息集
     */
    PageGridBean pageListSpecialComment(final String ownerId, final Integer state, final Long page, final Long pageSize);

}