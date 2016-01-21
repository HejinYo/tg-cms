package com.turingoal.cms.core.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 自定义字段
 */
@Data
public class CustomField implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 模型字段
    private Integer type; // 输入类型
    private Integer innerType; // 内部类型(1:用户自定义字段;2:系统定义字段;3:预留大文本字段;4:预留可查询字段)
    private String fieldLabel; // 字段标签
    private String fieldName; // 字段名称
    private String prompt; // 提示信息
    private String fieldDefaultValue; // 默认值
    private Integer required; // 是否必填项
    private Integer newline; // 是否独占一行
    private String regexStr; // 正则表达式
    private Integer fieldMaxLength; // 最大长度
    private Integer fieldMinLength; // 最小长度
    private Integer fieldMaxValue; // 最大值
    private Integer fieldMinValue; // 最小值
    private String dateFormat; // 日期格式
    private String checkboxOptions; // 可选项
    private Integer imgWidth; // 图片宽度
    private Integer imgHeight; // 图片高度
    private Integer imgTranscode; // 图片转码
    private String imgFormat; // 图片转码格式
    private Integer imgCompress; // 图片压缩
    private Integer imgExtrude; // 图片拉伸
    private Integer imgWatermark; // 添加水印
    private Integer videoTranscode; // 视频转码
    private String videoFormat; // 视频转码格式
    private String videoCodec; // 视频编码
    private Integer videoRate; // 视频码率
    private String ownerType; // ownerType
    private String ownerId; // ownerId
    private Integer sortOrder; // 顺序
    private Integer enabled; // 是否可用

    private String valueStr; // 值
    private Double valueForDouble; // 值-数字
    private String valueForLongText; // 值-富文本
    private java.util.Date valueForDate; // 值-日期
}