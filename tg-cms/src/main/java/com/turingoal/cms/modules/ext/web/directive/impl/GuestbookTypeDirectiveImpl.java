package com.turingoal.cms.modules.ext.web.directive.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.turingoal.cms.modules.ext.domain.GuestbookType;
import com.turingoal.cms.modules.ext.domain.query.GuestbookTypeQuery;
import com.turingoal.cms.modules.ext.service.GuestbookTypeService;
import com.turingoal.cms.modules.ext.web.directive.GuestbookTypeDirective;

/**
 * 留言类型DirectiveImpl
 */
@Component
public class GuestbookTypeDirectiveImpl implements GuestbookTypeDirective {
    @Autowired
    private GuestbookTypeService guestbookTypeService;

    @Override
    public List<GuestbookType> list() {
        GuestbookTypeQuery query = new GuestbookTypeQuery();
        return guestbookTypeService.findAll(query);
    }
}