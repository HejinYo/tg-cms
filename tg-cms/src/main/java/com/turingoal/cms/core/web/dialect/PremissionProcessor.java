package com.turingoal.cms.core.web.dialect;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.exceptions.TemplateProcessingException;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.standard.processor.AbstractStandardConditionalVisibilityTagProcessor;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.util.StringUtils;
import com.turingoal.cms.core.commons.SystemHelper;

/**
 * 权限permission Processor
 */
public class PremissionProcessor extends AbstractStandardConditionalVisibilityTagProcessor {

    public static final int PRECEDENCE = 10000; // 优先级
    public static final String DEFAULT_DIALECT_PREFIX = "tg_core"; // 默认前缀
    public static final String ATTR_NAME = "permission"; // 属性名称

    protected PremissionProcessor() {
        super(TemplateMode.HTML, DEFAULT_DIALECT_PREFIX, ATTR_NAME, PRECEDENCE);
    }

    /**
     * 是否显示
     */
    @Override
    protected boolean isVisible(final ITemplateContext context, final IProcessableElementTag tag, final AttributeName attributeName, final String attributeValue) {
        String premissionName = attributeValue.trim(); // 获取参数
        if (StringUtils.isEmptyOrWhitespace(premissionName)) {
            throw new TemplateProcessingException("参数不能为空！");
        }
        return SystemHelper.checkPermission(premissionName);
    }
}
