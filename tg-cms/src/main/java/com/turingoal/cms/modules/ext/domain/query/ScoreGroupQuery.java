package com.turingoal.cms.modules.ext.domain.query;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * 计分组Query
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ScoreGroupQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id; // 计分组
    private String groupName; // 名称
    private String codeNum; // 代码
    private String description; // 描述
    private Integer sortOrder; // 排序
}