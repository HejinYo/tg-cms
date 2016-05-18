package com.turingoal.cms.modules.ext.domain.query;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * 友情链接类型Query
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class FriendlinkTypeQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 友情链接类型
    private String typeName; // 名称
    private String codeNum; // 编码
    private String description; // 描述
    private Integer sortOrder; // 排序
    private Integer enabled; // 是否可用
}