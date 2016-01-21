package com.turingoal.cms.modules.ext.web.directive.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.turingoal.cms.modules.ext.domain.AdSlot;
import com.turingoal.cms.modules.ext.domain.query.AdSlotQuery;
import com.turingoal.cms.modules.ext.service.AdSlotService;
import com.turingoal.cms.modules.ext.web.directive.AdSlotDirective;

/**
 * 广告位DirectiveImpl
 */
@Component
public class AdSlotDirectiveImpl implements AdSlotDirective {
    @Autowired
    private AdSlotService adSlotService;

    @Override
    public List<AdSlot> list(final Integer slotType) {
        AdSlotQuery query = new AdSlotQuery();
        query.setSlotType(slotType);
        return adSlotService.findBySlotType(query);
    }

    @Override
    public AdSlot getByCode(final String codeNum) {
        AdSlotQuery query = new AdSlotQuery();
        query.setCodeNum(codeNum);
        return adSlotService.findByCodeNum(query);
    }
}