package com.turingoal.cms.modules.ext.repository;

import java.util.List;
import java.util.Map;
import com.turingoal.cms.modules.ext.domain.Vote;
import com.turingoal.cms.modules.ext.domain.form.VoteForm;
import com.turingoal.cms.modules.ext.domain.query.VoteQuery;

/**
 * 投票Dao 
 */
public interface VoteDao {
    
    /**
     * 查询 投票
     */
    List<Vote> find(final VoteQuery query);

    /**
     * 通过id得到一个 投票
     */
    Vote get(final String id);
    
    /**
     * 新增 投票
     */
    void add(final VoteForm form);

    /**
     * 修改 投票
     */
    int update(final VoteForm form);
    
    /**
     * 根据id删除一个 投票
     */
    int delete(final String id);
    
    /**
     * 修改投票状态
     */
    int changeState(final Map<String, Object> map);
}