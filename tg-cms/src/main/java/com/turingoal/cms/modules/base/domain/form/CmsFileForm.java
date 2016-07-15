package com.turingoal.cms.modules.base.domain.form;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * 文件Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CmsFileForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String format; // 格式
    private String fileName; // 文件名称
    private Long fileLength; // 文件长度
    private String filePath; // 文件地址
    private Date publishTime; // publishTime
    private String description; // 描述
    private String md5; // md5值
    private String title;
}