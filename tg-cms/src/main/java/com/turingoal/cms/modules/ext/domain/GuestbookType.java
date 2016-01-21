package com.turingoal.cms.modules.ext.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 留言板类型
 */
@Data
public class GuestbookType implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id; // 留言板
    private String typeName; // 名称
    private String codeNum; // 编码
    private Integer openType; // 开放模式
    private Integer verifyType; // 审核模式
    private Integer captchaType; // 验证码模式
    private Integer maxLength; // 最大长度
    private String description; // 描述
    private Integer sortOrder; // 排序
}