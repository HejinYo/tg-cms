package com.turingoal.cms.modules.base.domain.query;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * SpecialQuery
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SpecialQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id; // 专题
    private String modelId; // 模型
    private String typeId; // 专题类别
    private Date createDataTime; // 创建日期
    private String title; // 标题
    private String metaKeywords; // 关键字
    private String metaDescription; // 描述
    private String specialTemplate; // 专题模板
    private Integer refersCount; // 文档数量
    private Integer viewsCount; // 浏览总数
    private Integer withImage; // 是否有图片
    private Integer recommend; // 是否推荐
    private Integer enabled;
    private String typeName; // 专题类型

    private String image;
    private String video;
}