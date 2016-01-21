package com.turingoal.cms.modules.ext.web.directive;

import java.util.List;
import com.turingoal.cms.modules.ext.domain.Friendlink;

/**
 * 友情链接Directive
 */
public interface FriendLinkDirective {
    /**
     * 获取友情链接列表
     * 
     * @param typeId
     *            友情链接类别id
     * @param limit
     *            显示条数
     * @return 返回友情链接列表
     */
    List<Friendlink> list(final String typeId, final Long limit);
}