package com.turingoal.cms.modules.ext.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * 友情链接Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class FriendlinkForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String typeId; // 类型
    private String flName; // 网站名称
    private String flUrl; // 网站地址
    private String flLogo; // 网站Logo
    private String flEmail; // 站长Email
    private Integer recommend; // 是否推荐
    private String description; // 网站描述
    private Integer enabled = 1; // 状态 1启用 2停用
    private String typeName;
}