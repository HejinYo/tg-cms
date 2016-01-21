package com.turingoal.cms.core.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 角色
 */
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 角色表
    private String codeNum; // 编码
    private String roleName; // 角色名称
    private String description; // 描述
    private Integer sortOrder; // 排序
    private Integer editable; // 是否可编辑 1可编辑 2不可编辑
    private Integer enabled; // 是否可用
}