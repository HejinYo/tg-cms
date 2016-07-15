package com.turingoal.cms.modules.base.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * 视频Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CmsVideoForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String format; // 格式
    private String videoName; // 视频名称
    private String videoPath; // 视频地址
    private Long videoLength; // 视频大小
    private String videoTime; // 视频长度
    private java.util.Date publishTime; // publishTime
    private String description; // 描述
    private String md5;
    private String title;
}