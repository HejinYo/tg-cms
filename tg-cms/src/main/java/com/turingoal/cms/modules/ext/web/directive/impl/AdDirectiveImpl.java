package com.turingoal.cms.modules.ext.web.directive.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.turingoal.cms.modules.ext.domain.Ad;
import com.turingoal.cms.modules.ext.domain.query.AdQuery;
import com.turingoal.cms.modules.ext.service.AdService;
import com.turingoal.cms.modules.ext.web.directive.AdDirective;

/**
 * 广告DirectiveImpl
 */
@Component
public class AdDirectiveImpl implements AdDirective {
    @Autowired
    private AdService adService;

    @Override
    public List<Ad> listByCode(final String codeNum, final Long limit) {
        AdQuery query = new AdQuery();
        query.setCodeNum(codeNum);
        query.setLimit(limit);
        return adService.findByCodeNum(query);
    }
}