package com.turingoal.cms.core.domain;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseTreeNodeCheckBean;

/**
 * 权限
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ResourceCheckTreeNode extends BaseTreeNodeCheckBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nickname; // 权限中文名称
    private String code; // 权限代码
    private String resourceName; // 权限标记
}
