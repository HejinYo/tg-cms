package com.turingoal.cms.core.domain.query;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * 数据字典Query
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DictQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 数据字典
    private String dictType; // 字典类型
    private String dictName; // 字典名称
    private String dictValue; // 字典值
    private String description; // 描述
    private Integer sortOrder; // 排序
    private Integer editable; // 是否可编辑
    private Integer enabled; // 是否可用
}