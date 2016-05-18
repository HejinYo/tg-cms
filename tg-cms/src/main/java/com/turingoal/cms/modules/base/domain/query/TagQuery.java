package com.turingoal.cms.modules.base.domain.query;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * TagQuery
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TagQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id; // TAG
    private String tagName; // 名称
    private Date createDataTime; // 创建日期
    private Integer refers; // 文档数量
}