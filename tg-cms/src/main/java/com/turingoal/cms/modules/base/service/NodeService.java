package com.turingoal.cms.modules.base.service;

import java.util.List;
import java.util.Map;
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.base.domain.Node;
import com.turingoal.cms.modules.base.domain.form.NodeForm;
import com.turingoal.cms.modules.base.domain.query.NodeQuery;
import com.turingoal.common.bean.BaseTreeNodeBean;

/**
 * NodeService
 */
public interface NodeService {

    /**
     * 查询全部 Node
     */
    List<Node> findAll(final NodeQuery query);

    /**
     * 分页查询 Node
     */
    Page<Node> findByPage(final NodeQuery query);

    /**
     * 通过id得到一个 Node
     */
    Node get(final String id);

    /**
     * 通过codeNum得到一个 Node
     */
    Node getByCode(final String codeNum);

    /**
     * 新增 Node
     */
    void add(final NodeForm form, final Map<String, String> cusMap);

    /**
     * 修改 Node
     */
    int update(final NodeForm form, final Map<String, String> cusMap);

    /**
     * 根据id删除一个 Node
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
     * 查询全部 Node栏目树
     */

    BaseTreeNodeBean getNodeTreeGird(final NodeQuery query);

}