package com.turingoal.cms.modules.base.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 文章属性
 */
@Data
public class InfoAttrs implements Serializable {
    private static final long serialVersionUID = 1L;
    private String infoId; // 文章
    private String attributeId; // 属性
    private String image; // 属性图片
}