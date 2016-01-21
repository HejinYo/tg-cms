package com.turingoal.cms.modules.base.domain.query;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * InfoSpecialQuery 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class InfoSpecialQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer id; // 文档专题关联
    private String infoId; // 文档
    private Integer specialId; // 专题
    private Integer specialOrder; // 序号
}