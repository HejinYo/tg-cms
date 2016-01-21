package com.turingoal.cms.modules.base.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Tag
 */
@Data
public class Tag implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String tagName; // 名称
    private Date createDataTime; // 创建日期
    private Integer refers; // 文档数量
    private String relationId;
}