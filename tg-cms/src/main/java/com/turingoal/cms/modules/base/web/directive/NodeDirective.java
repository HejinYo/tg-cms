package com.turingoal.cms.modules.base.web.directive;

import java.util.List;
import com.turingoal.cms.modules.base.domain.Node;

/**
 * NodeDirective
 */
public interface NodeDirective {

    /**
     * 获取栏目列表
     * 
     * @param parentCode
     *            父栏目编码
     * @param limit
     *            显示条数
     * @return 返回栏目列表
     */
    List<Node> top(final String parentCode, final Long limit);

    /**
     * 根据id获取一个栏目信息
     * 
     * @param id
     *            栏目id
     * @return 返回栏目信息
     */
    Node getById(final String id);

    /**
     * 根据codeNum获取一个栏目信息
     * 
     * @param codeNum
     *            栏目编码
     * @return 返回栏目信息
     */
    Node getByCode(final String codeNum);

}