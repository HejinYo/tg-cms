package com.turingoal.cms.modules.base.domain;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseTreeNodeBean;

/**
 * 文件
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CmsFile extends BaseTreeNodeBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String format; // 格式
    private String fileName; // 文件名称
    private Long fileLength; // 文件长度
    private String filePath; // 文件地址
    private java.util.Date publishTime; // publishTime
    private java.util.Date createDataTime; // 创建时间
    private String description; // 描述
    private String md5; // md5值
    private String src;
}