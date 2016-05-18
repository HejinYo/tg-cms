package com.turingoal.cms.modules.ext.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * 计分牌Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ScoreRecordForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String scoreItemId; // 记分项
    private Integer votesCount; // 投票次数
    private String ownerType; // 外表标识
    private String ownerId; // 外表ID
}