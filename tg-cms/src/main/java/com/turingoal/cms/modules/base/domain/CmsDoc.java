package com.turingoal.cms.modules.base.domain;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseTreeNodeBean;

/**
 * 文档
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CmsDoc extends BaseTreeNodeBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String format; // 格式
    private String docName; // 文件名称
    private Long docLength; // 文件长度
    private String docPath; // 文件地址
    private java.util.Date publishTime; // publishTime
    private java.util.Date createDataTime; // 创建时间
    private String description; // 描述
    private String src;
}