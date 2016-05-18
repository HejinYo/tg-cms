package com.turingoal.cms.modules.ext.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * 计分项Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ScoreItemForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String groupId; // 计分组
    private String itemName; // 名称
    private Integer score; // 分值
    private String icon; // 图标
}