package com.turingoal.cms.modules.ext.domain.query;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * 计分项Query 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ScoreItemQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id; // 计分项
    private String groupId; // 计分组
    private String itemName; // 名称
    private Integer score; // 分值
    private String icon; // 图标
    private Integer sortOrder; // 排序
}