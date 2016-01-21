package com.turingoal.cms.core.domain;

import lombok.Data;

/**
 * 系统信息
 */
@Data
public class MoitorThreadinfo {
    private Long id;
    private String name; // 名称
    private String state; //状态
    private String lockName; // lockName
    private String lockOwnerName; //lockOwnerName
    private Long cpuTime; // cpuTime
}
