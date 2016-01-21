package com.turingoal.cms.modules.ext.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 友情链接类型
 */
@Data
public class FriendlinkType implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id; // 友情链接类型
    private String typeName; // 名称
    private String codeNum; // 编码
    private String description; // 描述
    private Integer sortOrder; // 排序
}