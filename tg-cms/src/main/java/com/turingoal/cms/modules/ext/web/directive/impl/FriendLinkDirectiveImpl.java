package com.turingoal.cms.modules.ext.web.directive.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.turingoal.cms.modules.ext.domain.Friendlink;
import com.turingoal.cms.modules.ext.domain.query.FriendlinkQuery;
import com.turingoal.cms.modules.ext.service.FriendlinkService;
import com.turingoal.cms.modules.ext.web.directive.FriendLinkDirective;

/**
 * 友情链接DirectiveImpl
 */
@Component
public class FriendLinkDirectiveImpl implements FriendLinkDirective {
    @Autowired
    private FriendlinkService friendlinkService;

    @Override
    public List<Friendlink> list(final String typeId, final Long limit) {
        FriendlinkQuery query = new FriendlinkQuery();
        query.setTypeId(typeId);
        query.setLimit(limit);
        return friendlinkService.findByTypeId(query);
    }
}