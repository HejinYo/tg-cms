package com.turingoal.cms.modules.ext.domain.query;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * 计分牌Query
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ScoreRecordQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id; // 计分牌
    private String scoreItemId; // 记分项
    private Integer votesCount; // 投票次数
    private String ownerType; // 外表标识
    private String ownerId; // 外表ID
}