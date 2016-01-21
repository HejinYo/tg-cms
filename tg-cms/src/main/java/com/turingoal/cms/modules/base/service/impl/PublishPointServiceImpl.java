package com.turingoal.cms.modules.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.modules.base.domain.PublishPoint;
import com.turingoal.cms.modules.base.domain.form.PublishPointForm;
import com.turingoal.cms.modules.base.domain.query.PublishPointQuery;
import com.turingoal.cms.modules.base.repository.PublishPointDao;
import com.turingoal.cms.modules.base.service.PublishPointService;
import com.turingoal.common.annotation.MethodLog;

/**
 * 发布点Service
 */
@Service
public class PublishPointServiceImpl implements PublishPointService {
    @Autowired
    private PublishPointDao publishPointDao;

    /**
     * 查询全部 PublishPoint
     */
    @MethodLog(name = "查询全部发布点", description = "根据条件查询全部的发布点，不分页")
    public Page<PublishPoint> findAll(final PublishPointQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        Page<PublishPoint> result = (Page<PublishPoint>) publishPointDao.find(query);
        return result;
    }

    /**
     * 通过id得到一个 发布点
     */
    @MethodLog(name = "通过id得到发布点", description = "通过id得到一个发布点")
    public PublishPoint get(final String id) {
        return publishPointDao.get(id);
    }

    /**
     * 新增 发布点
     */
    @MethodLog(name = "新增发布点", description = "新增一个发布点")
    public void add(final PublishPointForm form) {
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        publishPointDao.add(form);
    }

    /**
     * 修改 PublishPoint
     */
    @MethodLog(name = "修改发布点", description = "修改一个发布点")
    public int update(final PublishPointForm form) {
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        return publishPointDao.update(form);
    }

    /**
     * 根据id删除一个 发布点
     */
    @MethodLog(name = "删除发布点", description = "根据id删除一个发布点")
    public int delete(final String id) {
        return publishPointDao.delete(id);
    }
}