package com.turingoal.cms.core.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * 全局配置Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GlobalForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title; // 网站名称
    private String titleFull; // 网站全称
    private String domainName; // 域名
    private String copyInfo; // 版权信息
    private String icp; // icp备案
    private String sysVersion; // 版本号

    private String theme; // 主题
    private String noPic; // 暂无图片
    private String seoKeywords; // SEO关键字
    private String seoDescription; // SEO描述
    private String sysProtocol; // 协议
    private Integer sysPort; // 服务端口号
    private String contextPath; // 上下文路径
    private Integer withDomain; // 是否URL包含域名
    private Integer uploadsPublishpointId; // 附件发布点
}