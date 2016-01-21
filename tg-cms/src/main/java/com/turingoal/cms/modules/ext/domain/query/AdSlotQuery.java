package com.turingoal.cms.modules.ext.domain.query;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * 广告位Query 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AdSlotQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id; // 广告位
    private String slotName; // 名称
    private String codeNum; // 编码
    private Integer slotType; // 类型(1:文字,2:图片,3:FLASH,4:代码)
    private String slotTemplate; // 模板
    private Integer width; // 宽度
    private Integer height; // 高度
    private String description; // 描述
}