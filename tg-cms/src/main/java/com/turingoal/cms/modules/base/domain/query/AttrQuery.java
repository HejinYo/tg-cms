package com.turingoal.cms.modules.base.domain.query;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * AttrQuery 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AttrQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer id; // 属性
    private String codeNum; // 代码
    private String attName; // 名称
    private Integer withImage; // 是否包含图片
    private Integer imgScale; // 是否图片压缩
    private Integer imgExacte; // 是否图片拉伸
    private Integer addWatermark; // 是否图片水印
    private Integer imgWidth; // 图片宽度
    private Integer imgHeight; // 图片高度
    private Integer sortOrder; // 排序
}