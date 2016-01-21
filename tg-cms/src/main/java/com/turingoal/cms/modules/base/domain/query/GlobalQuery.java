package com.turingoal.cms.modules.base.domain.query;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * GlobalQuery
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GlobalQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id; // 全局
    private String sysProtocol; // 协议
    private Integer sysPort; // 服务端口号
    private String contextPath; // 上下文路径
    private Integer withDomain; // 是否URL包含域名
    private Integer uploadsPublishpointId; // 附件发布点
    private String sysVersion; // 版本号
}