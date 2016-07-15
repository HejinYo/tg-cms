package com.turingoal.cms.modules.base.domain.query;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * 栏目群组Query
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NodeGroupQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id; // 栏目与用户组权限
    private String nodeId; // 栏目
    private Integer groupId; // 用户组
    private Integer viewPerm; // 是否有浏览权限
    private Integer contriPerm; // 是否有投稿权限
    private Integer commentPerm; // 是否有评论权限
}