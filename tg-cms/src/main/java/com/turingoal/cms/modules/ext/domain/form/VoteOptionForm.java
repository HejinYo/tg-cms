package com.turingoal.cms.modules.ext.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * 投票选项Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class VoteOptionForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String voteId; // voteId
    private String title; // 标题
    private Integer voteCount; // 得票数
    private String description; // 描述
    private String romovedIds;
    private String mdifiedObjs;
    private String newObjs;
}