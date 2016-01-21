package com.turingoal.cms.modules.base.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 全局配置
 */
@Data
public class Global implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String sysProtocol; // 协议
    private Integer sysPort; // 服务端口号
    private String contextPath; // 上下文路径
    private Integer withDomain; // 是否URL包含域名
    private Integer uploadsPublishpointId; // 附件发布点
    private String sysVersion; // 版本号
}