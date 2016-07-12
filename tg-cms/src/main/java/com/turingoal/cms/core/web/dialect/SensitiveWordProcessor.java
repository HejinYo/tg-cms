package com.turingoal.cms.core.web.dialect;

import org.springframework.stereotype.Component;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.standard.processor.AbstractStandardExpressionAttributeTagProcessor;
import org.thymeleaf.templatemode.TemplateMode;
import com.turingoal.common.util.lang.SensitiveWordUtil;

/**
 * 敏感词替换 SensitiveWordProcessor
 */
@Component
public class SensitiveWordProcessor extends AbstractStandardExpressionAttributeTagProcessor {

    public static final int PRECEDENCE = 10000; // 优先级
    public static final String DEFAULT_DIALECT_PREFIX = "tg_core"; // 默认前缀
    public static final String ATTR_NAME = "sensitiveWord"; // 属性名称

    public SensitiveWordProcessor() {
        super(TemplateMode.HTML, DEFAULT_DIALECT_PREFIX, ATTR_NAME, PRECEDENCE, true);
    }

    /**
     * 处理
     */
    @Override
    protected void doProcess(final ITemplateContext context, final IProcessableElementTag tag, final AttributeName attributeName, final String attributeValue, final Object expressionResult, final IElementTagStructureHandler structureHandler) {
        String result = SensitiveWordUtil.replaceSensitiveWords(expressionResult.toString(), SensitiveWordUtil.MAX_MATCH);
        structureHandler.setBody(result, false);
    }
}
