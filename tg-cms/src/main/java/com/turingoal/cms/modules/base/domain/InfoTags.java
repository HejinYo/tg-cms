package com.turingoal.cms.modules.base.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * InfoTags
 */
@Data
public class InfoTags implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String infoId; // 文档
    private String tagId; // tag
    private Integer tagOrder; // tag序号
}