package com.turingoal.cms.modules.ext.repository;

import java.util.List;
import com.turingoal.cms.modules.ext.domain.Ad;
import com.turingoal.cms.modules.ext.domain.form.AdForm;
import com.turingoal.cms.modules.ext.domain.query.AdQuery;

/**
 * 广告管理Dao
 */
public interface AdDao {
    /**
     * 查询 所有广告管理信息
     */
    List<Ad> findAll(final AdQuery query);

    /**
     * 通过id得到一条广告管理信息
     */
    Ad get(final String id);

    /**
     * 新增 广告管理信息
     */
    void add(final AdForm form);

    /**
     * 修改 广告管理信息
     */
    int update(final AdForm form);

    /**
     * 根据id删除一条广告管理信息
     */
    int delete(final String id);
    
    /**
     * 根据typeId删除广告管理信息
     */
    int deleteByTypeId(final String typeId);

    /**
     * 根据广告位编码获取广告
     */
    List<Ad> findByCodeNum(AdQuery query);
}