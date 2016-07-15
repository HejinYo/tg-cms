package com.turingoal.cms.modules.base.domain.query;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * 文档Query
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CmsDocQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id; // id
    private String format; // 格式
    private String docName; // 文件名称
    private Long docLength; // 文件长度
    private String docPath; // 文件地址
    private java.util.Date publishTime; // publishTime
    private java.util.Date createDataTime; // 创建时间
    private String description; // 描述
    private Date startDate;
    private Date endDate;
    private Integer maxLength;
    private Integer minLength;
}