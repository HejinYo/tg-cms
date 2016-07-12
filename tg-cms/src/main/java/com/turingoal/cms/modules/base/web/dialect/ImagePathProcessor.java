package com.turingoal.cms.modules.base.web.dialect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.standard.processor.AbstractStandardExpressionAttributeTagProcessor;
import org.thymeleaf.templatemode.TemplateMode;
import com.turingoal.cms.modules.base.domain.CmsImage;
import com.turingoal.cms.modules.base.service.CmsImageService;
import com.turingoal.common.util.lang.StringUtil;

/**
 * 图片路径Processor
 */
@Component
public class ImagePathProcessor extends AbstractStandardExpressionAttributeTagProcessor {

    public static final int PRECEDENCE = 10000; // 优先级
    public static final String DEFAULT_DIALECT_PREFIX = "tg_core"; // 默认前缀
    public static final String ATTR_NAME = "img_path"; // 属性名称
    @Autowired
    private CmsImageService imageService;

    public ImagePathProcessor() {
        super(TemplateMode.HTML, DEFAULT_DIALECT_PREFIX, ATTR_NAME, PRECEDENCE, true);
    }

    /**
     * 处理
     */
    @Override
    protected void doProcess(final ITemplateContext context, final IProcessableElementTag tag, final AttributeName attributeName, final String attributeValue, final Object expressionResult, final IElementTagStructureHandler structureHandler) {
        String imageId = attributeValue.trim(); // 获取参数
        String iamgePath = "";
        if (!StringUtil.isNullOrBlank(imageId)) {
            CmsImage image = imageService.get(imageId);
            if (image != null) {
                iamgePath = image.getImgPath();
            }
        }
        structureHandler.setBody(iamgePath, false);
    }
}
