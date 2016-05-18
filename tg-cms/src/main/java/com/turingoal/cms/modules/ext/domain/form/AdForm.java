package com.turingoal.cms.modules.ext.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * 广告Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AdForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String adSlotId; // 广告板id
    private String adName; // 名称
    private java.util.Date beginTime; // 开始时间
    private java.util.Date endTime; // 结束时间
    private String adUrl; // 广告url
    private String adText; // 文字
    private String adScript; // 代码
    private String adIimage; // 图片
    private String adFlash; // flash

    private Integer startDrop;
    private Integer endDrop;
    private String dropPosition;
}