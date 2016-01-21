package com.turingoal.cms.core.domain.query;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * 自定义字段值Query
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CustomFieldValueQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id; // 自定义字段值
    private String keyStr; // 名称
    private String valueStr; // 值
    private String ownerType; // 类型
    private String ownerId; // 外表id
}