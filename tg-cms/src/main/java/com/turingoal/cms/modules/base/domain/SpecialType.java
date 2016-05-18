package com.turingoal.cms.modules.base.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 专题类型
 */
@Data
public class SpecialType implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String typeName; // 名称
    private Date createDataTime; // 创建日期
    private Integer viewsCount; // 浏览总数
    private String metaKeywords; // 关键字
    private String metaDescription; // 描述
    private Integer sortOrder; // 排序
    private Integer enabled; // 是否可用
}