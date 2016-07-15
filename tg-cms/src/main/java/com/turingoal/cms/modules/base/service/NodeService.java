package com.turingoal.cms.modules.base.service;

import java.util.List;
import java.util.Map;
import com.turingoal.cms.modules.base.domain.Node;
import com.turingoal.cms.modules.base.domain.form.NodeForm;
import com.turingoal.cms.modules.base.domain.query.NodeQuery;
import com.turingoal.common.bean.BaseTreeNodeBean;

/**
 * 栏目Service
 */
public interface NodeService {
    /**
     * 根据父栏目编码查询栏目
     */
    List<Node> findByParentCodeNum(final String parentCodeNum, final Long limit);

    /**
     * 查询全部 栏目
     */
    List<Node> findAll(final NodeQuery query);

    /**
     * 通过id得到一个 栏目
     */
    Node get(final String id);

    /**
     * 通过codeNum得到一个 栏目
     */
    Node getByCode(final String codeNum);

    /**
     * 新增 栏目
     */
    void add(final NodeForm form, final Map<String, String> cusMap);

    /**
     * 修改 栏目
     */
    int update(final NodeForm form, final Map<String, String> cusMap);

    /**
     * 根据id删除一个 栏目
     */
    String delete(final String id);

    /**
     * 启用
     */
    int enable(final String id);

    /**
     * 停用
     */

    int disable(final String id);

    /**
     * 查询全部 栏目栏目树
     */
    BaseTreeNodeBean getNodeTreeGird(final NodeQuery query);
}