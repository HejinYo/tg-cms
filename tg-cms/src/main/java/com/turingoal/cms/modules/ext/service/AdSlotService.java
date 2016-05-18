package com.turingoal.cms.modules.ext.service;

import java.util.List;
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.ext.domain.AdSlot;
import com.turingoal.cms.modules.ext.domain.form.AdSlotForm;
import com.turingoal.cms.modules.ext.domain.query.AdSlotQuery;

/**
 * 广告位Service
 */
public interface AdSlotService {

    /**
     * 查询全部 广告位
     */
    Page<AdSlot> findAll(final AdSlotQuery query);

    /**
     * 查询全部 广告位
     */
    List<AdSlot> findList(final AdSlotQuery query);

    /**
     * 通过id得到一个 广告位
     */
    AdSlot get(final String id);

    /**
     * 新增 广告位
     */
    void add(final AdSlotForm form);

    /**
     * 修改 广告位
     */
    int update(final AdSlotForm form);

    /**
     * 根据id删除一个 广告位
     */
    int delete(final String id);

    /**
     * 启用
     */
    void enable(final String id);

    /**
     * 停用
     */
    void disable(final String id);

    /**
     * 根据广告位类型获取广告位
     */
    List<AdSlot> findBySlotType(AdSlotQuery query);

    /**
     * 根据广告位编码获取广告位
     */
    AdSlot findByCodeNum(AdSlotQuery query);
}