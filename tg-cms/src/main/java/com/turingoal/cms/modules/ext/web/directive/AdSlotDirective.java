package com.turingoal.cms.modules.ext.web.directive;

import java.util.List;
import com.turingoal.cms.modules.ext.domain.AdSlot;

/**
 * 广告位Directive
 */
public interface AdSlotDirective {
    /**
     * 获取广告位信息
     * 
     * @param slotType
     *            广告位类型 1:文字,2:图片,3:FLASH,4:代码
     * @return 返回广告位信息集合
     */
    List<AdSlot> list(final Integer slotType);

    /**
     * 获取广告位信息
     * 
     * @param codeNum
     *            广告位编码
     * @return 返回广告位信息
     */
    AdSlot getByCode(final String codeNum);
}