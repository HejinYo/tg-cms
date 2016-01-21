package com.turingoal.cms.modules.base.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * PublishPointForm
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PublishPointForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String pName; // 名称
    private String description; // 描述
    private String storePath; // 保存路径
    private String displayPath; // 显示路径
    private String ftpHostname; // ftp服务器
    private Integer ftpPort; // ftp端口
    private String ftpUsername; // ftp用户名
    private String ftpPassword; // ftp密码
    private Integer pMethod = 1; // 方式(1:文件系统,2:FTP)
    private Integer pType = 1; // 类型(1:HTML发布,2:附件发布)
}