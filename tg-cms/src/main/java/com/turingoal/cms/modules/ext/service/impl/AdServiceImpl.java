package com.turingoal.cms.modules.ext.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.modules.ext.domain.Ad;
import com.turingoal.cms.modules.ext.domain.form.AdForm;
import com.turingoal.cms.modules.ext.domain.query.AdQuery;
import com.turingoal.cms.modules.ext.repository.AdDao;
import com.turingoal.cms.modules.ext.service.AdService;
import com.turingoal.common.annotation.MethodLog;

/**
 * 广告管理Service
 */
@Service
public class AdServiceImpl implements AdService {
    @Autowired
    private AdDao adDao;

    /**
     * 根据广告位编码获取广告
     */
    @Override
    public List<Ad> findBySlot(final AdQuery query) {
        return adDao.findBySlot(query);
    }

    /**
     * 查询全部 广告管理信息
     */
    @MethodLog(name = "查询全部 广告管理信息", description = "查询全部 广告管理信息,不分页")
    public Page<Ad> findAll(final AdQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        Page<Ad> result = (Page<Ad>) adDao.find(query);
        return result;
    }

    /**
     * 通过id得到一条广告信息
     */
    @MethodLog(name = "通过id得到广告信息", description = "通过id得到一条广告信息")
    public Ad get(final String id) {
        return adDao.get(id);
    }

    /**
     * 新增 广告信息
     */
    @MethodLog(name = "新增 广告信息", description = "新增一条广告信息")
    public void add(final AdForm form) {
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        adDao.add(form);
    }

    /**
     * 修改广告管理信息
     */
    @MethodLog(name = "修改广告管理信息", description = "修改一条广告管理信息")
    public int update(final AdForm form) {
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        return adDao.update(form);
    }

    /**
     * 根据id删除一条广告管理信息
     */
    @MethodLog(name = "根据id删除一条广告管理信息", description = "根据id删除一条广告管理信息")
    public int delete(final String id) {
        return adDao.delete(id);
    }
}