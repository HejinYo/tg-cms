package com.turingoal.cms.modules.ext.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * 友情链接类型Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class FriendlinkTypeForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String typeName; // 名称
    private String codeNum; // 编码
    private String description; // 描述
}