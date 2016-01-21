package com.turingoal.cms.modules.ext.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 计分牌 
 */
@Data
public class ScoreRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id; // 计分牌
    private String scoreItemId; // 记分项
    private Integer votesCount; // 投票次数
    private String ownerType; // 外表标识
    private String ownerId; // 外表ID
}