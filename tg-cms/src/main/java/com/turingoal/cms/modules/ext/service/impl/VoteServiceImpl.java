package com.turingoal.cms.modules.ext.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.modules.ext.domain.Vote;
import com.turingoal.cms.modules.ext.domain.VoteOption;
import com.turingoal.cms.modules.ext.domain.form.VoteForm;
import com.turingoal.cms.modules.ext.domain.form.VoteOptionForm;
import com.turingoal.cms.modules.ext.domain.query.VoteOptionQuery;
import com.turingoal.cms.modules.ext.domain.query.VoteQuery;
import com.turingoal.cms.modules.ext.repository.VoteDao;
import com.turingoal.cms.modules.ext.repository.VoteOptionDao;
import com.turingoal.cms.modules.ext.service.VoteService;
import com.turingoal.common.annotation.MethodLog;

/**
 * 投票Service
 */
@Service
public class VoteServiceImpl implements VoteService {
    @Autowired
    private VoteDao voteDao;
    @Autowired
    private VoteOptionDao voteOptionDao;

    /**
     * 查询全部 投票
     */
    @MethodLog(name = "查询全部投票", description = "根据条件查询全部的投票，不分页")
    public List<Vote> findAll(final VoteQuery query) {
        return voteDao.find(query);
    }

    /**
     * 分页查询 投票
     */
    @MethodLog(name = "分页查询投票", description = "根据条件分页查询投票")
    public Page<Vote> findByPage(final VoteQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        return (Page<Vote>) voteDao.find(query);
    }

    /**
     * 通过id得到一个 投票
     */
    @MethodLog(name = "通过id得到投票", description = "通过id得到一个投票")
    public Vote get(final String id) {
        return voteDao.get(id);
    }

    /**
     * 新增 投票
     */
    @MethodLog(name = "新增投票", description = "新增一个投票，返回id")
    public void add(final VoteForm form) {
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        voteDao.add(form);
    }

    /**
     * 修改 投票
     */
    @MethodLog(name = "修改投票", description = "修改一个投票")
    public int update(final VoteForm form) {
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        return voteDao.update(form);
    }

    /**
     * 根据id删除一个投票
     */
    @MethodLog(name = "删除投票", description = "根据id删除一个投票")
    public int delete(final String id) {
        return voteDao.delete(id);
    }

    /**
     * 查询全部 投票选项
     */
    @MethodLog(name = "查询全部投票选项", description = "根据条件查询全部的投票选项，不分页")
    public List<VoteOption> findAllOption(final VoteOptionQuery query) {
        return voteOptionDao.find(query);
    }

    /**
     * 修改 投票选项
     */
    /*
     * @MethodLog(name = "修改投票选项", description = "修改投票选项") public int updateOption(final VoteOptionForm form) { List<VoteOptionForm> updateList = JsonUtil.json2List(form.getMdifiedObjs(), VoteOptionForm.class); if (updateList != null) { for (VoteOptionForm uForm : updateList) {
     * voteOptionDao.update(uForm); } } List<VoteOptionForm> addList = JsonUtil.json2List(form.getNewObjs(), VoteOptionForm.class); if (addList != null) { for (VoteOptionForm aForm : addList) { voteOptionDao.add(aForm); } } List<String> idList = new ArrayList<String>(); String ids =
     * form.getRomovedIds(); if (!StringUtil.isNullOrEmpty(ids)) { // 截取json数据中的‘,’ Iterable<String> split = Splitter.on(",").split(ids); // 迭代截取后的数据 Iterator<String> it = split.iterator(); // 循环删除 while (it.hasNext()) { idList.add(it.next()); } } if (idList != null && idList.size() > 0) {
     * voteOptionDao.deleteAll(idList); } return 1; }
     */

    /**
     * 查询根据投票id查询投票选项
     */
    @MethodLog(name = "查询根据投票id查询投票选项", description = "查询根据投票id查询投票选项，不分页")
    public VoteOption getOption(final String id) {
        return voteOptionDao.get(id);
    }

    /**
     * 查询根据投票id查询投票选项
     */
    @MethodLog(name = "查询根据投票id查询投票选项", description = "查询根据投票id查询投票选项，不分页")
    public List<VoteOption> findOption(final VoteOptionQuery query) {
        return voteOptionDao.find(query);
    }

    /**
     * 新增投票选项信息
     */
    @MethodLog(name = "新增投票选项信息", description = "新增投票选项信息")
    public int addOption(final VoteOptionForm form) {
        return voteOptionDao.add(form);
    }

    /**
     * 修改 投票
     */
    @MethodLog(name = "修改投票", description = "修改一个投票")
    public int updateOption(final VoteOptionForm form) {
        return voteOptionDao.update(form);
    }

    /**
     * 根据id删除一个投票选项
     */
    @MethodLog(name = "删除投票选项", description = "根据id删除一个投票选项")
    public int deleteOption(final String id) {
        return voteOptionDao.delete(id);
    }

    /**
     * 启用
     */
    @MethodLog(name = "启用投票", description = "根据id启用一个投票")
    public int enable(final String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("enabled", 1);
        return voteDao.changeState(params);
    }

    /**
     * 停用
     */
    @MethodLog(name = "停用投票", description = "根据id停用一个投票")
    public int disable(final String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("enabled", 2);
        return voteDao.changeState(params);
    }
}