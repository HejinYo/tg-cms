package com.turingoal.cms.modules.base.domain.form;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseFormBean;

/**
 * 文章Form
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class InfoForm extends BaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nodeId; // 栏目
    private java.util.Date publishTime = new Date(); // 发布日期
    private java.util.Date offTime; // 关闭日期
    private Date lastUpdateTime = new Date(); // 最后更新时间
    private String createDataUsername; // 创建者
    private Integer sortOrder; // 排序
    private Integer withImage; // 是否包含图片
    private Integer viewsCount; // 浏览总数
    private Integer downloadsCount; // 下载总数
    private Integer commentsCount; // 评论总数
    private Integer diggs; // 顶
    private Integer score; // 得分
    private Integer htmlState; // htmlState
    private String htmlPath; // HTML页面
    private String title; // 主标题
    private String subtitle; // 副标题
    private String fullTitle; // 完整标题
    private String linkPath; // 转向链接
    private String newWindow; // 是否在新窗口打开
    private String titleColor; // 颜色
    private Integer titleStrong; // 是否粗体
    private Integer titleEm; // 是否斜体
    private String infoPath; // 文档路径
    private String infoTemplate; // 文档模板
    private String metaKeywords; // 关键字
    private String metaDescription; // 描述
    private String source; // 来源名称
    private String sourceUrl; // 来源url
    private String author; // 作者
    private String infoText; // 正文

    private Integer allowComment; // 是否允许评论
    private Integer state; // 10待审核，1审核通过（已审核），2不通过（退回）
    private String nodeName; // 所属栏目名称
    private String infoModelId; // 文档模型id
    private String creatorName; // 创建者姓名

    private String image; // 图片
    private String video; // 视频
    private String doc; // 文档

    private String tagId;
    private String relationId;
    private String attrIds;
    private String imageIds;
    private String specialId;
    private Integer specialOrder;
}