package com.turingoal.cms.modules.ext.web.directive;

import java.util.List;
import com.turingoal.cms.modules.ext.domain.GuestbookType;

/**
 * 留言类型Directive
 */
public interface GuestbookTypeDirective {
    /**
     * 获取所有留言类型
     * 
     * @return 返回留言类型集合
     */
List<GuestbookType> list();
}