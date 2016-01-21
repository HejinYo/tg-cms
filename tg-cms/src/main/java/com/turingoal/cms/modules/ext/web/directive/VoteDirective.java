package com.turingoal.cms.modules.ext.web.directive;

import com.turingoal.cms.modules.ext.domain.Vote;

/**
 * 投票Directive
 */
public interface VoteDirective {
    /**
     * 获取投票信息
     * 
     * @param codeNum
     *            投票编码
     * @return 返回投票
     */
Vote getByCode(final String codeNum);
}