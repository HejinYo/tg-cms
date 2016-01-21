package com.turingoal.cms.modules.ext.web.directive;

import com.turingoal.cms.modules.ext.domain.Question;

/**
 * 问卷Directive
 */
public interface QuestionDirective {
    /**
     * 获取问卷调查信息
     * 
     * @param codeNum
     *            问卷编码
     * @return 返回问卷信息
     */
Question getByCode(final String codeNum);
}