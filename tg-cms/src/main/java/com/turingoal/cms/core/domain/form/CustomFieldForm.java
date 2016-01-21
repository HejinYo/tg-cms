package com.turingoal.cms.core.domain.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * 自定义字段Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CustomFieldForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;
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
    private String dropPosition;

    public CustomFieldForm() {

    }

    /**
     * 自定义字段
     * 
     * @param type
     *            输入类型
     * @param fieldLabel
     *            字段标签
     * @param fieldName
     *            字段名称
     * @param innerType
     *            内部类型
     * @param newline
     *            是否独占一行
     * @param required
     *            是否必填
     */
    public CustomFieldForm(final Integer typeParm, final String fieldLabelParm, final String fieldNameParm, final Integer innerTypeParm, final Integer newlineParm, final Integer requiredParm) {
        this.type = typeParm;
        this.fieldLabel = fieldLabelParm;
        this.fieldName = fieldNameParm;
        this.innerType = innerTypeParm;
        this.newline = newlineParm;
        this.required = requiredParm;
    }
}