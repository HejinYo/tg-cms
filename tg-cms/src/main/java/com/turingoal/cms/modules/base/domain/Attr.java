package com.turingoal.cms.modules.base.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 文章属性
 */
@Data
public class Attr implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String codeNum; // 代码
    private String attName; // 名称
    private Integer withImage; // 是否包含图片
    private Integer imgScale; // 是否图片压缩
    private Integer imgExacte; // 是否图片拉伸
    private Integer addWatermark; // 是否图片水印
    private Integer imgWidth; // 图片宽度
    private Integer imgHeight; // 图片高度
    private Integer sortOrder; // 排序
    private String infoId; // 文章id
    private String image; // 属性图片
    private String attributeId;
    private String imagePath;
}