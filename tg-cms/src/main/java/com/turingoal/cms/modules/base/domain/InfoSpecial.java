package com.turingoal.cms.modules.base.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 文章专题
 */
@Data
public class InfoSpecial implements Serializable {
    private static final long serialVersionUID = 1L;
    private String infoId; // 文章
    private String specialId; // 专题
    private Integer specialOrder; // 序号
}