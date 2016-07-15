package com.turingoal.cms.modules.base.domain.form;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;
import com.turingoal.common.util.validator.ValidGroupUpdate;

/**
 * 文章专题Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class InfoSpecialForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull(message = "【文档专题关联 Id】不能为空！", groups = { ValidGroupUpdate.class })
    private String infoId; // 文档
    private String specialId; // 专题
    private Integer specialOrder; // 序号
    private Integer startDrop;
    private Integer endDrop;
    private String dropPosition;
}