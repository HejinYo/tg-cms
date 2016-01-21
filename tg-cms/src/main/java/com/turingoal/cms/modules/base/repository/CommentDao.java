package com.turingoal.cms.modules.base.repository;

import java.util.List;
import java.util.Map;
import com.turingoal.cms.modules.base.domain.Comment;
import com.turingoal.cms.modules.base.domain.form.CommentForm;
import com.turingoal.cms.modules.base.domain.query.CommentQuery;

/**
 * CommentDao 
 */
public interface CommentDao {
    
    /**
     * 查询 Comment
     */
    List<Comment> find(final CommentQuery query);
    
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
     * 修改状态
     */
    int changeState(final Map<String, Object> map);
}