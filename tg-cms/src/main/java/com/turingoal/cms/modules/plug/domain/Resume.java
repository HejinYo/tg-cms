package com.turingoal.cms.modules.plug.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Resume 
 */
@Data
public class Resume implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id; // 招聘
    private String username; // 姓名
    private String applyPost; // 应聘职位
    private Date createDataTime; // 投递日期
    private Integer gender; // 性别
    private Date birthday; // 出生日期
    private String cellphoneNum; // 手机
    private String email; // 邮箱
    private Integer expectedSalary; // 期望薪水
    private String educationExperience; // 教育经历
    private String workExperience; // 工作经历
    private String remarks; // 备注
    private Integer state; // state
}