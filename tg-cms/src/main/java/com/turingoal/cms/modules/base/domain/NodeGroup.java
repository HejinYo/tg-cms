package com.turingoal.cms.modules.base.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * NodeGroup
 */
@Data
public class NodeGroup implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nodeId; // 栏目
    private String groupId; // 用户组
    private Integer viewPerm; // 是否有浏览权限
    private Integer contriPerm; // 是否有投稿权限
    private Integer commentPerm; // 是否有评论权限
}