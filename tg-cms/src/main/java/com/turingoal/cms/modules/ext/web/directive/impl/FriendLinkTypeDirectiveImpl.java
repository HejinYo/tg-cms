package com.turingoal.cms.modules.ext.web.directive.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.turingoal.cms.modules.ext.domain.FriendlinkType;
import com.turingoal.cms.modules.ext.domain.query.FriendlinkTypeQuery;
import com.turingoal.cms.modules.ext.service.FriendlinkTypeService;
import com.turingoal.cms.modules.ext.web.directive.FriendLinkTypeDirective;

/**
 * 友情链接类型DirectiveImpl
 */
@Component
public class FriendLinkTypeDirectiveImpl implements FriendLinkTypeDirective {
    @Autowired
    private FriendlinkTypeService friendlinkTypeService;

    @Override
    public List<FriendlinkType> list() {
        FriendlinkTypeQuery query = new FriendlinkTypeQuery();
        return friendlinkTypeService.findAll(query);
    }

}