package com.turingoal.cms.modules.ext.domain.query;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * 广告Query
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AdQuery extends BaseQueryBean implements Serializable {
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
    private String codeNum; // 广告位编码
}