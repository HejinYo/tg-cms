package com.turingoal.cms.modules.ext.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * 计分组Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ScoreGroupForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String groupName; // 名称
    private String codeNum; // 代码
    private String description; // 描述
}