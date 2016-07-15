package com.turingoal.cms.modules.base.domain.query;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * 模板Query
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TemplateQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id; // 模板
    private String templateName; // 模板名称
    private String codeNum; // 模板代码
    private Date createDataTime; // 创建时间
    private String description; // 描述
    private Integer sortOrder; // 排序
}