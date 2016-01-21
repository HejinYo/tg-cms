package com.turingoal.cms.modules.ext.web.directive.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.turingoal.cms.modules.ext.domain.Question;
import com.turingoal.cms.modules.ext.domain.query.QuestionQuery;
import com.turingoal.cms.modules.ext.service.QuestionService;
import com.turingoal.cms.modules.ext.web.directive.QuestionDirective;

/**
 * 问卷DirectiveImpl
 */
@Component
public class QuestionDirectiveImpl implements QuestionDirective {
    @Autowired
    private QuestionService questionService;

    @Override
    public Question getByCode(final String codeNum) {
        QuestionQuery query = new QuestionQuery();
        query.setCodeNum(codeNum);
        return questionService.findByCodeNum(query);
    }
}