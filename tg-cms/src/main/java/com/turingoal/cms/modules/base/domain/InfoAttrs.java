package com.turingoal.cms.modules.base.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * InfoAttrs
 */
@Data
public class InfoAttrs implements Serializable {
    private static final long serialVersionUID = 1L;

    private String infoId; // 文档
    private String attributeId; // 属性
    private String image; // 属性图片
}