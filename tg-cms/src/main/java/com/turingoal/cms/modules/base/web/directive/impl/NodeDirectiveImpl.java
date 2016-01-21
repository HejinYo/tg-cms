package com.turingoal.cms.modules.base.web.directive.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.turingoal.cms.modules.base.domain.Node;
import com.turingoal.cms.modules.base.domain.query.NodeQuery;
import com.turingoal.cms.modules.base.service.NodeService;
import com.turingoal.cms.modules.base.web.directive.NodeDirective;
import com.turingoal.common.annotation.MethodLog;

/**
 * NodeDirective
 */
@Component
public class NodeDirectiveImpl implements NodeDirective {
    @Autowired
    private NodeService nodeService;

    /**
     * 获取栏目列表
     */
    @MethodLog(name = "获取栏目列表", description = "获取栏目列表，不分页")
    public List<Node> top(final String parentCode, final Long limit) {
        NodeQuery query = new NodeQuery();
        String nodeId = parentCode == null ? "0" : nodeService.getByCode(parentCode).getId();
        query.setParentId(nodeId);
        query.setRealNode(1);
        query.setHidden(2);
        query.setLimit(limit);
        if (limit != null && limit > 0) {
            return nodeService.findByPage(query);
        }
        return nodeService.findAll(query);
    }

    /**
     * 根据id获取栏目信息
     */
    @MethodLog(name = "根据id获取栏目信息", description = "根据id获取栏目信息")
    public Node getById(final String id) {
        return nodeService.get(id);
    }

    /**
     * 根据codeNum获取栏目信息表
     */
    @MethodLog(name = "根据codeNum获取栏目信息", description = "根据codeNum获取栏目信息")
    public Node getByCode(final String codeNum) {
        return nodeService.getByCode(codeNum);
    }

}