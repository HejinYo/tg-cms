package com.turingoal.cms.modules.base.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Special
 */
@Data
public class Special implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String modelId; // 模型
    private String typeId; // 专题类别
    private String title; // 标题
    private String metaKeywords; // 关键字
    private String metaDescription; // 描述
    private String specialTemplate; // 专题模板
    private Integer refersCount; // 文档数量
    private Integer viewsCount; // 浏览总数
    private Integer withImage; // 是否有图片
    private Integer recommend; // 是否推荐
    private Integer enabled; // 1
    private String typeName; // 专题类型
    private String image; // 图片
    private String video; // 视频
    private Date createDataTime;
    private String createDataUsername;
    private Date updateDataTime;
    private String updateDataUsername;
}