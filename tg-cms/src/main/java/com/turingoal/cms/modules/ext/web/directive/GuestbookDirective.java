package com.turingoal.cms.modules.ext.web.directive;

import java.util.List;
import com.turingoal.cms.modules.ext.domain.Guestbook;

/**
 * 留言Directive
 */
public interface GuestbookDirective {
    /**
     * 获取留言排行
     */
    List<Guestbook> top(final String codeNum, final Integer recommend, final Long limit);

    /**
     * 分页查询留言列表
     */
    List<Guestbook> pageList(final String codeNum, final Integer recommend, final Long pageSize, final Long page);

}