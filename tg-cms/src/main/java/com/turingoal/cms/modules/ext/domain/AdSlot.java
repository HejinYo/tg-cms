package com.turingoal.cms.modules.ext.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 广告位
 */
@Data
public class AdSlot implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 广告位
    private String slotName; // 名称
    private String codeNum; // 编码
    private Integer slotType; // 类型(1:文字,2:图片,3:FLASH,4:代码)
    private String slotTemplate; // 模板
    private Integer width; // 宽度
    private Integer height; // 高度
    private String description; // 描述
    private Integer sortOrder; // 排序
    private Integer enabled; // 是否可用
}