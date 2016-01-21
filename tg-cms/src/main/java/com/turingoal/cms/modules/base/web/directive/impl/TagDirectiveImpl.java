package com.turingoal.cms.modules.base.web.directive.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.turingoal.cms.modules.base.domain.Tag;
import com.turingoal.cms.modules.base.domain.query.TagQuery;
import com.turingoal.cms.modules.base.service.TagService;
import com.turingoal.cms.modules.base.web.directive.TagDirective;

/**
 * 标签DirectiveImpl
 */
@Component
public class TagDirectiveImpl implements TagDirective {
    @Autowired
    private TagService tagService;

    @Override
    public List<Tag> list(final Integer refers, final Long limit) {
        TagQuery query = new TagQuery();
        query.setRefers(refers);
        query.setLimit(limit);
        return tagService.findByPage(query);
    }
}