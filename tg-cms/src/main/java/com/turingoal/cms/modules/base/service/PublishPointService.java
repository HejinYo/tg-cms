package com.turingoal.cms.modules.base.service;

import com.github.pagehelper.Page;
import com.turingoal.cms.modules.base.domain.PublishPoint;
import com.turingoal.cms.modules.base.domain.form.PublishPointForm;
import com.turingoal.cms.modules.base.domain.query.PublishPointQuery;

/**
 * 发布点Service
 */
public interface PublishPointService {

    /**
     * 查询全部 发布点
     */
    Page<PublishPoint> findAll(final PublishPointQuery query);

    /**
     * 通过id得到一个 发布点
     */
    PublishPoint get(final String id);

    /**
     * 新增 发布点
     */
    void add(final PublishPointForm form);

    /**
     * 修改 发布点
     */
    int update(final PublishPointForm form);

    /**
     * 根据id删除一个 发布点
     */
    int delete(final String id);
}