package com.turingoal.cms.modules.ext.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 计分组 
 */
@Data
public class ScoreGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id; // 计分组
    private String groupName; // 名称
    private String codeNum; // 代码
    private String description; // 描述
    private Integer sortOrder; // 排序
}