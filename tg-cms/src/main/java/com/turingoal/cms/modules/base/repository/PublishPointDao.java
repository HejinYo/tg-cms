package com.turingoal.cms.modules.base.repository;

import java.util.List;
import com.turingoal.cms.modules.base.domain.PublishPoint;
import com.turingoal.cms.modules.base.domain.form.PublishPointForm;
import com.turingoal.cms.modules.base.domain.query.PublishPointQuery;

/**
 * PublishPointDao
 */
public interface PublishPointDao {

    /**
     * 查询全部 PublishPoint
     */
    List<PublishPoint> find(final PublishPointQuery query);

    /**
     * 通过id得到一个 PublishPoint
     */
    PublishPoint get(final String id);

    /**
     * 新增 PublishPoint
     */
    void add(final PublishPointForm form);

    /**
     * 修改 PublishPoint
     */
    int update(final PublishPointForm form);

    /**
     * 根据id删除一个 PublishPoint
     */
    int delete(final String id);

    /**
     * 查询发布类型为1的全部数据
     */
    List<PublishPoint> findByType();
}