package com.turingoal.cms.modules.base.domain.query;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * 视频Query
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CmsVideoQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id; // 视频
    private String format; // 格式
    private String videoName; // 视频名称
    private String videoPath; // 视频地址
    private Long videoLength; // 视频大小
    private String videoTime; // 视频长度
    private java.util.Date publishTime; // publishTime
    private java.util.Date createDataTime; // 创建时间
    private String description; // 描述
    private Date startDate;
    private Date endDate;
    private Integer maxLength;
    private Integer minLength;
}