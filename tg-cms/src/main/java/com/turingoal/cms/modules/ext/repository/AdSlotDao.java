package com.turingoal.cms.modules.ext.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.turingoal.cms.modules.ext.domain.AdSlot;
import com.turingoal.cms.modules.ext.domain.form.AdSlotForm;
import com.turingoal.cms.modules.ext.domain.query.AdSlotQuery;

/**
 * 广告位Dao
 */
public interface AdSlotDao {

    /**
     * 查询 广告位信息
     */
    List<AdSlot> find(final AdSlotQuery query);

    /**
     * 通过id得到一个 广告位信息
     */
    AdSlot get(final String id);

    /**
     * 通过名称等到一个留言板类型
     */
    AdSlot getBySlotName(final String slotName);

    /**
     * 通过编码的得到一个留言板类型
     */
    AdSlot getByCodeNum(final String codeNum);

    /**
     * 新增 广告位信息
     */
    void add(final AdSlotForm form);

    /**
     * 修改 广告位信息
     */
    int update(final AdSlotForm form);

    /**
     * 根据id删除一个 广告位信息
     */
    int delete(final String id);

    /**
     * 修改是否可用
     */
    int changeEnabled(@Param("id") final String id, @Param("enabled") final Integer enabled);

    /**
     * 根据广告位类型获取广告位
     */
    List<AdSlot> findBySlotType(AdSlotQuery query);

    /**
     * 根据广告位编码获取广告位
     */
    AdSlot findByCodeNum(AdSlotQuery query);
}