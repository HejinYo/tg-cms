package com.turingoal.cms.modules.base.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.turingoal.common.bean.BaseFormBean;

/**
 * 图片Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CmsImageForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String format; // 格式
    private String imgName; // 图片名称
    private Long imgLength; // 文件长度
    private String imgPath; // 图片地址
    private String imgText; // 图片正文
    private Integer imgWidth; // 宽度
    private Integer imgHeight; // 高度
    private java.util.Date publishTime; // publishTime
    private String description; // 描述
    private CommonsMultipartFile file;
    private String md5;
    private Integer isWatermarked;
    private String watermarkPicture; // 水印图片
    private Integer watermarkPosition; // 水印位置
    private String title;
}