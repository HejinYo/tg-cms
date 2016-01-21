package com.turingoal.cms.modules.base.domain.query;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * FileQuery
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CmsFileQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id; // 文件
    private String format; // 格式
    private String fileName; // 文件名称
    private Long fileLength; // 文件长度
    private String filePath; // 文件地址
    private java.util.Date publishTime; // publishTime
    private java.util.Date createDataTime; // 创建时间
    private String description; // 描述
    private String md5; // md5值
    
    private Date startDate;
    private Date endDate;
    private Integer maxLength;
    private Integer minLength;
    private String ids; // 查询id的字符串
    private String [] idStrs;
}