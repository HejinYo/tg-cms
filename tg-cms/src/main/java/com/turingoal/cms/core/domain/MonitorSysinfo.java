package com.turingoal.cms.core.domain;

import lombok.Data;

/**
 * 系统信息
 */
@Data
public class MonitorSysinfo {
    private String type; // 类型
    private String name; // 名称
    private String value; // 值

    public MonitorSysinfo(final String typeParm, final String nameParm, final String valueParm) {
        this.type = typeParm;
        this.name = nameParm;
        this.value = valueParm;
    }
}
