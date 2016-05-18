package com.turingoal.cms.modules.base.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * NodeRoleForm
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NodeRoleForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer roleId; // roleId
    private Integer nodeId; // nodeId
    private Integer nodePerm; // 栏目权限
    private Integer infoPerm; // 文档权限
}