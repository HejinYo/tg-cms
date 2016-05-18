package com.turingoal.cms.modules.base.domain.query;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * CommentQuery
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CommentQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id; // 评论
    private String createDataUsername; // 创建人
    private String auditorId; // 审核人
    private String ownerType; // 外表标识
    private String ownerId; // 外表ID
    private String content; // 评论内容
    private java.util.Date createDataTime; // 评论时间
    private java.util.Date auditTime; // 审核时间
    private String userIp; // IP地址
    private Integer score; // 得分
    private Integer status; // 10:未审核;1:已审核;2:屏蔽;3:推荐
}