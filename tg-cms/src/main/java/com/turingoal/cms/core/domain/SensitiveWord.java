package com.turingoal.cms.core.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 敏感词
 */
@Data
public class SensitiveWord implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 敏感词
    private String word; // 敏感词
    private String replacement; // 替换词
    private Integer enabled; // 是否可用
}