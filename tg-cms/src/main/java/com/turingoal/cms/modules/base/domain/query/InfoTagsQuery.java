package com.turingoal.cms.modules.base.domain.query;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * 文章TagsQuery
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class InfoTagsQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id; // 文档标签关联
    private String infoId; // 文档
    private Integer tagId; // tag
    private Integer tagOrder; // tag序号
}