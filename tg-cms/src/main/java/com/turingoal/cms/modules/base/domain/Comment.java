package com.turingoal.cms.modules.base.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 评论
 */
@Data
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
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