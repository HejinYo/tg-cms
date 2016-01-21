package com.turingoal.cms.modules.ext.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.modules.ext.domain.VoteMark;
import com.turingoal.cms.modules.ext.domain.form.VoteMarkForm;
import com.turingoal.cms.modules.ext.domain.query.VoteMarkQuery;
import com.turingoal.cms.modules.ext.repository.VoteMarkDao;
import com.turingoal.cms.modules.ext.service.VoteMarkService;
import com.turingoal.common.annotation.MethodLog;

/**
 * 投票标记Service
 */
@Service
public class VoteMarkServiceImpl implements VoteMarkService {
    @Autowired
    private VoteMarkDao voteMarkDao;

    /**
     * 查询全部 投票标记
     */
    @MethodLog(name = "查询全部投票标记", description = "根据条件查询全部的投票标记，不分页")
    public List<VoteMark> findAll(final VoteMarkQuery query) {
        return voteMarkDao.find(query);
    }

    /**
     * 分页查询 投票标记
     */
    @MethodLog(name = "分页查询投票标记", description = "根据条件分页查询投票标记")
    public Page<VoteMark> findByPage(final VoteMarkQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        return (Page<VoteMark>) voteMarkDao.find(query);
    }

    /**
     * 通过id得到一个 投票标记
     */
    @MethodLog(name = "通过id得到投票标记", description = "通过id得到一个投票标记")
    public VoteMark get(final String id) {
        return voteMarkDao.get(id);
    }

    /**
     * 新增 投票标记
     */
    @MethodLog(name = "新增投票标记", description = "新增一个投票标记，返回id")
    public void add(final VoteMarkForm form) {
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        voteMarkDao.add(form);
    }

    /**
     * 修改 投票标记
     */
    @MethodLog(name = "修改投票标记", description = "修改一个投票标记")
    public int update(final VoteMarkForm form) {
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        return voteMarkDao.update(form);
    }

    /**
     * 根据id删除一个 投票标记
     */
    @MethodLog(name = "删除投票标记", description = "根据id删除一个投票标记")
    public int delete(final String id) {
        return voteMarkDao.delete(id);
    }
}