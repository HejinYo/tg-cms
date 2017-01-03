package com.turingoal.cms.modules.ext.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.modules.ext.domain.AdSlot;
import com.turingoal.cms.modules.ext.domain.form.AdSlotForm;
import com.turingoal.cms.modules.ext.domain.query.AdSlotQuery;
import com.turingoal.cms.modules.ext.repository.AdSlotDao;
import com.turingoal.cms.modules.ext.service.AdSlotService;
import com.turingoal.common.annotation.MethodLog;
import com.turingoal.common.constants.ConstantEnabledValue;

/**
 * 广告位Service
 */
@Service
public class AdSlotServiceImpl implements AdSlotService {
    @Autowired
    private AdSlotDao adSlotDao;

    /**
     * 查询全部 广告位
     */
    @MethodLog(name = "查询全部广告位", description = "根据条件查询全部的广告位，不分页")
    public Page<AdSlot> findAll(final AdSlotQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        Page<AdSlot> result = (Page<AdSlot>) adSlotDao.find(query);
        return result;
    }

    /**
     * 通过id得到一个 广告位
     */
    @MethodLog(name = "通过id得到广告位", description = "通过id得到一个广告位")
    public AdSlot get(final String id) {
        return adSlotDao.get(id);
    }

    /**
     * 通过名称等到一个留言板类型
     */
    @MethodLog(name = "通过名称等到一个留言板类型", description = "通过名称等到一个留言板类型")
    public AdSlot getBySlotName(final String slotName) {
        return adSlotDao.getBySlotName(slotName);
    }

    /**
     * 通过编码的得到一个留言板类型
     */
    @MethodLog(name = "通过编码的得到一个留言板类型", description = "通过编码的得到一个留言板类型")
    public AdSlot getByCodeNum(final String codeNum) {
        return adSlotDao.getByCodeNum(codeNum);
    }

    /**
     * 新增 广告位
     */
    @MethodLog(name = "新增广告位", description = "新增一个广告位")
    public void add(final AdSlotForm form) {
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        adSlotDao.add(form);
    }

    /**
     * 修改 广告位
     */
    @MethodLog(name = "修改广告位", description = "修改一个广告位")
    public int update(final AdSlotForm form) {
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        return adSlotDao.update(form);
    }

    /**
     * 根据id删除一个 广告位
     */
    @MethodLog(name = "删除广告位", description = "根据id删除一个广告位")
    public int delete(final String id) {
        return adSlotDao.delete(id);
    }

    /**
     * 启用
     */
    @MethodLog(name = "启用友情链接类型", description = "根据id启用一个友情链接类型")
    public void enable(final String id) {
        adSlotDao.changeEnabled(id, ConstantEnabledValue.ENABLED_INT);
    }

    /**
     * 停用
     */
    @MethodLog(name = "停用广告位", description = "根据id停用一个广告位")
    public void disable(final String id) {
        adSlotDao.changeEnabled(id, ConstantEnabledValue.DISABLED_INT);
    }

    /**
     * 根据广告位类型获取广告位
     */
    @MethodLog(name = "根据广告位类型获取广告位", description = "根据广告位类型获取广告位")
    public List<AdSlot> findBySlotType(final AdSlotQuery query) {
        return adSlotDao.findBySlotType(query);
    }

    /**
     * 根据广告位编码获取广告位
     */
    @MethodLog(name = "根据广告位编码获取广告位", description = "根据广告位编码获取广告位")
    public AdSlot findByCodeNum(final AdSlotQuery query) {
        return adSlotDao.findByCodeNum(query);
    }

    /**
     * 所有广告位的list
     */
    @Override
    public List<AdSlot> findList(final AdSlotQuery query) {
        return adSlotDao.find(query);
    }

}