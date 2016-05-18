package com.turingoal.cms.modules.base.domain.query;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * InfoAttrsQuery
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class InfoAttrsQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id; // 文档与属性关联
    private String infoId; // 文档
    private Integer attributeId; // 属性
    private String image; // 属性图片
}