package com.turingoal.cms.modules.ext.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.modules.ext.domain.FriendlinkType;
import com.turingoal.cms.modules.ext.domain.form.FriendlinkTypeForm;
import com.turingoal.cms.modules.ext.domain.query.FriendlinkTypeQuery;
import com.turingoal.cms.modules.ext.repository.FriendlinkTypeDao;
import com.turingoal.cms.modules.ext.service.FriendlinkTypeService;
import com.turingoal.common.annotation.MethodLog;
import com.turingoal.common.constants.ConstantEnabledValue;

/**
 * 友情链接类型Service
 */
@Service
public class FriendlinkTypeServiceImpl implements FriendlinkTypeService {
    @Autowired
    private FriendlinkTypeDao friendlinkTypeDao;

    /**
     * 查询全部 友情链接类型
     */
    @MethodLog(name = "查询全部友情链接类型", description = "根据条件查询全部的友情链接类型，不分页")
    public Page<FriendlinkType> findAll(final FriendlinkTypeQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        Page<FriendlinkType> result = (Page<FriendlinkType>) friendlinkTypeDao.find(query);
        return result;
    }

    /**
     * 通过id得到一个 友情链接类型
     */
    @MethodLog(name = "通过id得到友情链接类型", description = "通过id得到一个友情链接类型")
    public FriendlinkType get(final String id) {
        return friendlinkTypeDao.get(id);
    }

    /**
     * 通过名称等到一个友情链接类型
     */
    @MethodLog(name = "通过名称等到一个友情链接类型", description = "通过名称等到一个友情链接类型")
    public FriendlinkType getByTypeName(final String typeName) {
        return friendlinkTypeDao.getByTypeName(typeName);
    }

    /**
     * 通过编码的得到一个友情链接类型
     */
    @MethodLog(name = "通过编码的得到一个友情链接类型", description = "通过编码的得到一个友情链接类型")
    public FriendlinkType getByCodeNum(final String codeNum) {
        return friendlinkTypeDao.getByCodeNum(codeNum);
    }

    /**
     * 新增 友情链接类型
     */
    @MethodLog(name = "新增友情链接类型", description = "新增一个友情链接类型，返回id")
    public void add(final FriendlinkTypeForm form) {
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        friendlinkTypeDao.add(form);
    }

    /**
     * 修改 友情链接类型
     */
    @MethodLog(name = "修改友情链接类型", description = "修改一个友情链接类型")
    public int update(final FriendlinkTypeForm form) {
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        return friendlinkTypeDao.update(form);
    }

    /**
     * 根据id删除一个 友情链接类型
     */
    @MethodLog(name = "删除友情链接类型", description = "根据id删除一个友情链接类型")
    public int delete(final String id) {
        return friendlinkTypeDao.delete(id);
    }

    /**
     * 启用
     */
    @MethodLog(name = "启用友情链接类型", description = "根据id启用一个友情链接类型")
    public void enable(final String id) {
        friendlinkTypeDao.changeEnabled(id, ConstantEnabledValue.ENABLED_INT);
    }

    /**
     * 停用
     */
    @MethodLog(name = "停用友情链接类型", description = "根据id停用一个友情链接类型")
    public void disable(final String id) {
        friendlinkTypeDao.changeEnabled(id, ConstantEnabledValue.DISABLED_INT);
    }

}