package com.turingoal.cms.modules.plug.domain.query;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * ResumeQuery 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ResumeQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id; // 招聘
    private String username; // 姓名
    private String applyPost; // 应聘职位
    private java.util.Date createDate; // 投递日期
    private Integer gender; // 性别
    private java.util.Date birthday; // 出生日期
    private String cellphoneNum; // 手机
    private String email; // 邮箱
    private Integer expectedSalary; // 期望薪水
    private String educationExperience; // 教育经历
    private String workExperience; // 工作经历
    private String remarks; // 备注
    private Integer state; // state
}