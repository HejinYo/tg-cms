package com.turingoal.cms.modules.base.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 模板
 */
@Data
public class Template implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String templateName; // 模板名称
    private String codeNum; // 模板代码
    private Date createDataTime; // 创建时间
    private String description; // 描述
    private Integer sortOrder; // 排序
}