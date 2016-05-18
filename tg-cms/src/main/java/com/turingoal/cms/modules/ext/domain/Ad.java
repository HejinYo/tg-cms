package com.turingoal.cms.modules.ext.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 广告
 */
@Data
public class Ad implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id; // 广告
    private String adSlotId; // 广告板id
    private String adName; // 名称
    private java.util.Date beginTime; // 开始时间
    private java.util.Date endTime; // 结束时间
    private String adUrl; // 广告url
    private String adText; // 文字
    private String adScript; // 代码
    private String adIimage; // 图片
    private String adFlash; // flash
    private Integer sortOrder; // 排序
    private String slotName;
}