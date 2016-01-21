package com.turingoal.cms.core.domain.query;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * 角色Query
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RoleQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 角色表
    private String codeNum; // 编码
    private String roleName; // 角色名称
    private String description; // 描述
    private Integer editable; // 是否可编辑
    private Integer enabled; // 是否可用
}