package com.turingoal.cms.modules.ext.web.directive;

import java.util.List;
import com.turingoal.cms.modules.ext.domain.Ad;

/**
 * 广告Directive
 */
public interface AdDirective {
    /**
     * 根据广告位编码获取广告信息
     * 
     * @param codeNum
     *            广告位编码
     * @param limit
     *            显示条数
     * @return 返回广告信息
     */
    List<Ad> listByCode(final String codeNum, final Long limit);
}