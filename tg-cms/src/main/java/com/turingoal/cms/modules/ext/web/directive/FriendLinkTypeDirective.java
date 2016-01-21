package com.turingoal.cms.modules.ext.web.directive;

import java.util.List;
import com.turingoal.cms.modules.ext.domain.FriendlinkType;

/**
 * 友情链接类型Directive
 */
public interface FriendLinkTypeDirective {
    /**
     * 获取所有友情链接类型
     * 
     * @return 返回友情链接类型集合
     */
    List<FriendlinkType> list();
}