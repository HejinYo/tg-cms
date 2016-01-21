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
import com.turingoal.cms.modules.ext.repository.AdDao;
import com.turingoal.cms.modules.ext.repository.AdSlotDao;
import com.turingoal.cms.modules.ext.service.AdSlotService;
import com.turingoal.common.annotation.MethodLog;

/**
 * 广告位Service
 */
@Service
public class AdSlotServiceImpl implements AdSlotService {
    @Autowired
    private AdSlotDao adSlotDao;
    @Autowired
    private AdDao adDao;

    /**
     * 查询全部 广告位
     */
    @MethodLog(name = "查询全部AdSlot", description = "根据条件查询全部的AdSlot，不分页")
    public Page<AdSlot> findAll(final AdSlotQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        Page<AdSlot> result = (Page<AdSlot>) adSlotDao.find(query);
        return result;
    }

    /**
     * 通过id得到一个 广告位
     */
    @MethodLog(name = "通过id得到AdSlot", description = "通过id得到一个AdSlot")
    public AdSlot get(final String id) {
        return adSlotDao.get(id);
    }

    /**
     * 新增 广告位
     */
    @MethodLog(name = "新增AdSlot", description = "新增一个AdSlot，返回id")
    public void add(final AdSlotForm form) {
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        adSlotDao.add(form);
    }

    /**
     * 修改 广告位
     */
    @MethodLog(name = "修改AdSlot", description = "修改一个AdSlot")
    public int update(final AdSlotForm form) {
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        return adSlotDao.update(form);
    }

    /**
     * 根据id删除一个 广告位
     */
    @MethodLog(name = "删除AdSlot", description = "根据id删除一个AdSlot")
    public int delete(final String id) {
        adDao.deleteByTypeId(id);
        return adSlotDao.delete(id);
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
        // TODO Auto-generated method stub
        return adSlotDao.find(query);
    }
}