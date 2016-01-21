package com.turingoal.cms.modules.ext.service;

import java.util.List;
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.ext.domain.Vote;
import com.turingoal.cms.modules.ext.domain.VoteOption;
import com.turingoal.cms.modules.ext.domain.form.VoteForm;
import com.turingoal.cms.modules.ext.domain.form.VoteOptionForm;
import com.turingoal.cms.modules.ext.domain.query.VoteOptionQuery;
import com.turingoal.cms.modules.ext.domain.query.VoteQuery;

/**
 * 投票Service
 */
public interface VoteService {

    /**
     * 查询全部 投票
     */
    List<Vote> findAll(final VoteQuery query);

    /**
     * 分页查询 投票
     */
    Page<Vote> findByPage(final VoteQuery query);

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
     * 新增投票选项
     */
    int addOption(final VoteOptionForm form);

    /**
     * 修改投票选项
     */
    int updateOption(final VoteOptionForm form);

    /**
     * 通过id得到一个 投票选项
     */
    VoteOption getOption(final String id);

    /**
     * 查询全部 投票选项
     */
    List<VoteOption> findAllOption(final VoteOptionQuery query);

    /**
     * 查询根据投票id查询投票选项
     */
    List<VoteOption> findOption(final VoteOptionQuery query);

    /**
     * 根据id删除一个 投票选项
     */
    int deleteOption(final String id);

    /**
     * 启用
     */
    int enable(final String id);

    /**
     * 停用
     */
    int disable(final String id);
}