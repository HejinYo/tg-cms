package com.turingoal.cms.core.domain.query;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * 资源Query
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ResourceQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 资源表
    private String codeNum; // 编码
    private String resourceName; // 名称
    private String iconCls; // 图标
    private Integer type; // 资源类型 1菜单 2按钮 3方法
    private String code; // 权限代码
    private String permission; // 权限标识
    private String permValue; // 权限值
    private String description; // 描述
    private String parentId; // 父级资源
    private Integer sortOrder; // 排序
    private Integer editable; // 是否可编辑 1可编辑 2不可编辑
    private Integer enabled; // 是否可用
}