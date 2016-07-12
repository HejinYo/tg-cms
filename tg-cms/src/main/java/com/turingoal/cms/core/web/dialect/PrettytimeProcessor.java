package com.turingoal.cms.core.web.dialect;

import java.util.Date;
import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.standard.processor.AbstractStandardExpressionAttributeTagProcessor;
import org.thymeleaf.templatemode.TemplateMode;

/**
 * 日期美化 prettytimeProcessor
 */
@Component
public class PrettytimeProcessor extends AbstractStandardExpressionAttributeTagProcessor {

    public static final int PRECEDENCE = 10000; // 优先级
    public static final String DEFAULT_DIALECT_PREFIX = "tg_core"; // 默认前缀
    public static final String ATTR_NAME = "prettytime"; // 属性名称

    public PrettytimeProcessor() {
        super(TemplateMode.HTML, DEFAULT_DIALECT_PREFIX, ATTR_NAME, PRECEDENCE, true);
    }

    /**
     * 处理
     */
    @Override
    protected void doProcess(final ITemplateContext context, final IProcessableElementTag tag, final AttributeName attributeName, final String attributeValue, final Object expressionResult, final IElementTagStructureHandler structureHandler) {
        PrettyTime p = new PrettyTime();
        structureHandler.setBody(p.format((Date) expressionResult), false);
    }
}
