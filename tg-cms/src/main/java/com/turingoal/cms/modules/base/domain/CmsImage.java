package com.turingoal.cms.modules.base.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 图片
 */
@Data
public class CmsImage implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String format; // 格式
    private String imgName; // 图片名称
    private Long imgLength; // 文件长度
    private String imgPath; // 图片地址
    private String imgText; // 图片正文
    private Integer imgWidth; // 宽度
    private Integer imgHeight; // 高度
    private java.util.Date publishTime; // publishTime
    private java.util.Date createDataTime; // 创建时间
    private String description; // 描述
    private String src;
}