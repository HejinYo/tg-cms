package com.turingoal.cms.modules.ext.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.modules.ext.domain.Friendlink;
import com.turingoal.cms.modules.ext.domain.form.FriendlinkForm;
import com.turingoal.cms.modules.ext.domain.query.FriendlinkQuery;
import com.turingoal.cms.modules.ext.repository.FriendlinkDao;
import com.turingoal.cms.modules.ext.service.FriendlinkService;
import com.turingoal.common.annotation.MethodLog;

/**
 * 友情链接Service
 */
@Service
public class FriendlinkServiceImpl implements FriendlinkService {
    @Autowired
    private FriendlinkDao friendlinkDao;

    /**
     * 查询启用的友情链接
     */
    @MethodLog(name = "查询启用的友情链接", description = "根据条件查询启用的友情链接，不分页")
    public List<Friendlink> findEnabled(final FriendlinkQuery query) {
        return friendlinkDao.findEnabled(query);
    }

    /**
     * 查询全部 友情链接
     */
    @MethodLog(name = "查询全部友情链接", description = "根据条件查询全部的友情链接，分页")
    public Page<Friendlink> find(final FriendlinkQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        Page<Friendlink> result = (Page<Friendlink>) friendlinkDao.find(query);
        return result;
    }

    /**
     * 通过id得到一个 友情链接
     */
    @MethodLog(name = "通过id得到友情链接", description = "通过id得到一个友情链接")
    public Friendlink get(final String id) {
        return friendlinkDao.get(id);
    }

    /**
     * 新增 友情链接
     */
    @MethodLog(name = "新增友情链接", description = "新增一个友情链接，返回id")
    public void add(final FriendlinkForm form) {
        form.setEditable(1);
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        friendlinkDao.add(form);
    }

    /**
     * 修改 友情链接
     */
    @MethodLog(name = "修改友情链接", description = "修改一个友情链接")
    public int update(final FriendlinkForm form) {
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        return friendlinkDao.update(form);
    }

    /**
     * 根据id删除一个 友情链接
     */
    @MethodLog(name = "删除友情链接", description = "根据id删除一个友情链接")
    public int delete(final String id) {
        return friendlinkDao.delete(id);
    }

    /**
     * 启用
     */
    @MethodLog(name = "启用友情链接", description = "根据id启用一个友情链接")
    public int enable(final String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("enabled", 1);
        return friendlinkDao.changeState(params);
    }

    /**
     * 停用
     */
    @MethodLog(name = "停用友情链接", description = "根据id停用一个友情链接")
    public int disable(final String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("enabled", 2);
        return friendlinkDao.changeState(params);
    }

    /**
     * 根据类型获取友情链接
     */
    @MethodLog(name = "根据类型获取友情链接", description = "根据类型获取友情链接")
    public List<Friendlink> findByTypeId(final FriendlinkQuery query) {
        return friendlinkDao.find(query);
    }

    /**
     * 根据id更改友情链接推荐状态
     */
    @MethodLog(name = "根据id更改友情链接推荐状态", description = "根据id更改友情链接推荐状态")
    public int changeRecommend(final FriendlinkForm form) {
        return friendlinkDao.changeRecommend(form);
    }
}