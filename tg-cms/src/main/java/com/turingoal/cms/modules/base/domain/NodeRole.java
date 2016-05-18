package com.turingoal.cms.modules.base.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * NodeRole
 */
@Data
public class NodeRole implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String roleId; // roleId
    private String nodeId; // nodeId
    private Integer nodePerm; // 栏目权限
    private Integer infoPerm; // 文档权限
}