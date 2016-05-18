package com.turingoal.cms.modules.ext.repository;

import java.util.List;
import com.turingoal.cms.modules.ext.domain.VoteOption;
import com.turingoal.cms.modules.ext.domain.form.VoteOptionForm;
import com.turingoal.cms.modules.ext.domain.query.VoteOptionQuery;

/**
 * 投票项表Dao
 */
public interface VoteOptionDao {

    /**
     * 查询 投票项表
     */
    List<VoteOption> find(final VoteOptionQuery query);

    /**
     * 通过id得到一个 投票项表
     */
    VoteOption get(final String id);

    /**
     * 新增 投票项表
     */
    int add(final VoteOptionForm form);

    /**
     * 修改 投票项表
     */
    int update(final VoteOptionForm form);

    /**
     * 根据id删除一个 投票项表
     */
    int delete(final String id);

    /**
     * 根据id删除多个 投票项表(List)
     */
    int deleteAll(final List<String> ids);
}