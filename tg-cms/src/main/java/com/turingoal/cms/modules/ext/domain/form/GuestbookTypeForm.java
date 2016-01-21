package com.turingoal.cms.modules.ext.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * 留言板类型Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GuestbookTypeForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String typeName; // 名称
    private String codeNum; // 编码
    private Integer openType; // 开放模式
    private Integer verifyType; // 审核模式
    private Integer captchaType; // 验证码模式
    private Integer maxLength; // 最大长度
    private String description; // 描述
}