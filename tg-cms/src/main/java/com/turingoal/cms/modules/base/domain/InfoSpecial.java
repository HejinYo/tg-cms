package com.turingoal.cms.modules.base.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * InfoSpecial
 */
@Data
public class InfoSpecial implements Serializable {
    private static final long serialVersionUID = 1L;

    private String infoId; // 文档
    private String specialId; // 专题
    private Integer specialOrder; // 序号
}