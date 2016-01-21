package com.turingoal.cms.modules.base.domain.form;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * DocForm
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CmsDocForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String format; // 格式
    private String docName; // 文件名称
    private Long docLength; // 文件长度
    private String docPath; // 文件地址
    private Date publishTime; // publishTime
    private String description; // 描述
    private String md5;
    private String title;
}