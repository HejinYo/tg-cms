package com.turingoal.cms.core.domain;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseTreeNodeBean;

/**
 * 资源
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Resource extends BaseTreeNodeBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String codeNum; // 编码
    private String resourceName; // 名称
    private String iconCls; // 图标
    private Integer type; // 资源类型
    private String code; // 权限代码
    private String permission; // 权限标识
    private String permValue; // 权限
    private String description; // 描述
    private boolean expanded = true; // 是否展开
    private Integer sortOrder; // 排序
    private Integer editable; // 是否可编辑
    private Integer enabled; // 是否可用
}