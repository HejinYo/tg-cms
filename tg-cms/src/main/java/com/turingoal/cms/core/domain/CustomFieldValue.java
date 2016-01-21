package com.turingoal.cms.core.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 自定义字段值
 */
@Data
public class CustomFieldValue implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 自定义字段值
    private String keyStr; // 名称
    private String ownerType; // 类型
    private String ownerId; // 外表id
    private String valueStr; // 值
    private Double valueForDouble; // 值-数字
    private String valueForLongText; // 值-富文本
    private java.util.Date valueForDate; // 值-日期
}