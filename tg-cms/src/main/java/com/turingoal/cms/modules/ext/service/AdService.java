package com.turingoal.cms.modules.ext.service;

import java.util.List;
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.ext.domain.Ad;
import com.turingoal.cms.modules.ext.domain.form.AdForm;
import com.turingoal.cms.modules.ext.domain.query.AdQuery;

/**
 * 广告管理Service
 */
public interface AdService {

    /**
     * 查询全部广告管理信息
     */
    Page<Ad> findAll(final AdQuery query);

    /**
     * 通过id得到一条广告信息
     */
    Ad get(final String id);

    /**
     * 新增 一条广告信息
     */
    void add(final AdForm form);

    /**
     * 修改广告管理信息
     */
    int update(final AdForm form);

    /**
     * 根据id删除一条广告管理信息
     */
    int delete(final String id);

    /**
     * 根据广告位编码获取广告
     */
    List<Ad> findByCodeNum(AdQuery query);
}