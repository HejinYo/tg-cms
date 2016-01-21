package com.turingoal.cms.modules.base.web.directive.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.turingoal.cms.modules.base.domain.SpecialType;
import com.turingoal.cms.modules.base.domain.query.SpecialTypeQuery;
import com.turingoal.cms.modules.base.service.SpecialTypeService;
import com.turingoal.cms.modules.base.web.directive.SpecialTypeDirective;

/**
 * SpecialTypeDirective
 */
@Component
public class SpecialTypeDirectiveImpl implements SpecialTypeDirective {
    @Autowired
    private SpecialTypeService specialTypeService;

    /**
     * list
     */
    public List<SpecialType> list() {
        SpecialTypeQuery query = new SpecialTypeQuery();
        return specialTypeService.findAll(query);
    }
}