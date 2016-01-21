package com.turingoal.cms.core.domain.query;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * 敏感词Query
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SensitiveWordQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 敏感词
    private String word; // 敏感词
    private String replacement; // 替换词
    private Integer enabled; // 是否可用
}