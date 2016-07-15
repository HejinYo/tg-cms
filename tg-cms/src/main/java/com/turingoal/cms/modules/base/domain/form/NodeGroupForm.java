package com.turingoal.cms.modules.base.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * 栏目Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NodeGroupForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer nodeId; // 栏目
    private Integer groupId; // 用户组
    private Integer viewPerm; // 是否有浏览权限
    private Integer contriPerm; // 是否有投稿权限
    private Integer commentPerm; // 是否有评论权限
}