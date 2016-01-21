package com.turingoal.cms.modules.ext.repository;

import java.util.List;
import com.turingoal.cms.modules.ext.domain.VoteMark;
import com.turingoal.cms.modules.ext.domain.form.VoteMarkForm;
import com.turingoal.cms.modules.ext.domain.query.VoteMarkQuery;

/**
 * 投票标记Dao 
 */
public interface VoteMarkDao {
    
    /**
     * 查询 投票标记
     */
    List<VoteMark> find(final VoteMarkQuery query);

    /**
     * 通过id得到一个 投票标记
     */
    VoteMark get(final String id);
    
    /**
     * 新增 投票标记
     */
    void add(final VoteMarkForm form);

    /**
     * 修改 投票标记
     */
    int update(final VoteMarkForm form);
    
    /**
     * 根据id删除一个 投票标记
     */
    int delete(final String id);
}