package com.turingoal.cms.modules.ext.web.directive.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.turingoal.cms.modules.ext.domain.Guestbook;
import com.turingoal.cms.modules.ext.domain.query.GuestbookQuery;
import com.turingoal.cms.modules.ext.service.GuestbookService;
import com.turingoal.cms.modules.ext.web.directive.GuestbookDirective;

/**
 * 留言DirectiveImpl
 */
@Component
public class GuestbookDirectiveImpl implements GuestbookDirective {
    @Autowired
    private GuestbookService guestbookService;

    @Override
    public List<Guestbook> top(final String codeNum, final Integer recommend, final Long limit) {
        GuestbookQuery query = new GuestbookQuery();
        query.setCodeNum(codeNum);
        query.setRecommend(recommend);
        query.setLimit(limit);
        return guestbookService.top(query);
    }

    @Override
    public List<Guestbook> pageList(final String codeNum, final Integer recommend, final Long pageSize, final Long page) {
        GuestbookQuery query = new GuestbookQuery();
        query.setCodeNum(codeNum);
        query.setRecommend(recommend);
        query.setPage(page);
        query.setLimit(pageSize);
        return guestbookService.findByPage(query);
    }
}