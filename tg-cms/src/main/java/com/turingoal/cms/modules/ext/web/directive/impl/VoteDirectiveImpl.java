package com.turingoal.cms.modules.ext.web.directive.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.turingoal.cms.modules.ext.domain.Vote;
import com.turingoal.cms.modules.ext.service.VoteService;
import com.turingoal.cms.modules.ext.web.directive.VoteDirective;

/**
 * 投票DirectiveImpl
 */
@Component
public class VoteDirectiveImpl implements VoteDirective {
    @Autowired
    private VoteService voteService;

    @Override
    public Vote getByCode(final String codeNum) {
        return null;
    }
}