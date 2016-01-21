package com.turingoal.cms.modules.base.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * Model
 */
@Data
public class Model implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String type; // 类型(info:文档,node:栏目,home:首页;special:专题)
    private String modelName; // 名称
    private String codeNum; // 代码
    private String description; // 备注
    private Integer sortOrder; // 排序
}