package com.turingoal.cms.modules.base.domain;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseTreeNodeBean;

/**
 * 视频
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CmsVideo extends BaseTreeNodeBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String format; // 格式
    private String videoName; // 视频名称
    private String videoPath; // 视频地址
    private Long videoLength; // 视频大小
    private String videoTime; // 视频长度
    private java.util.Date publishTime; // publishTime
    private java.util.Date createDataTime; // 创建时间
    private String description; // 描述
    private String src;
}