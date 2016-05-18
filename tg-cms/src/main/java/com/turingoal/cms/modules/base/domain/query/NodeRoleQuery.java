package com.turingoal.cms.modules.base.domain.query;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * NodeRoleQuery
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NodeRoleQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id; // 文档角色关联
    private Integer roleId; // roleId
    private String nodeId; // nodeId
    private Integer nodePerm; // 栏目权限
    private Integer infoPerm; // 文档权限
}