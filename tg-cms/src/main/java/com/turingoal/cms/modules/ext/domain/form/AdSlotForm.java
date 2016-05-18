package com.turingoal.cms.modules.ext.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * 广告位Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AdSlotForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String slotName; // 名称
    private String codeNum; // 编码
    private Integer slotType; // 类型(1:文字,2:图片,3:FLASH,4:代码)
    private String slotTemplate; // 模板
    private Integer width; // 宽度
    private Integer height; // 高度
    private String description; // 描述
}