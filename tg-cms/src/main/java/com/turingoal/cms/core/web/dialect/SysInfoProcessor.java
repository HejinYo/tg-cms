package com.turingoal.cms.core.web.dialect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.exceptions.TemplateProcessingException;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.standard.processor.AbstractStandardExpressionAttributeTagProcessor;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.util.StringUtils;
import com.turingoal.cms.core.domain.Global;
import com.turingoal.cms.core.service.GlobalService;

/**
 * 系统基本信息 SysInfoProcessor
 */
@Component
public class SysInfoProcessor extends AbstractStandardExpressionAttributeTagProcessor {
    public static final int PRECEDENCE = 10000; // 优先级
    public static final String DEFAULT_DIALECT_PREFIX = "tg_core"; // 默认前缀
    public static final String ATTR_NAME = "sys_info"; // 属性名称

    public SysInfoProcessor() {
        super(TemplateMode.HTML, DEFAULT_DIALECT_PREFIX, ATTR_NAME, PRECEDENCE, true);
    }

    @Autowired
    private GlobalService globalService;

    /**
     * 处理
     */
    @Override
    protected void doProcess(final ITemplateContext context, final IProcessableElementTag tag, final AttributeName attributeName, final String attributeValue, final Object expressionResult, final IElementTagStructureHandler structureHandler) {
        Global globalConfig = globalService.get();
        String result = "---请输入正确的参数---";
        String varStr = attributeValue.trim(); // 获取参数
        if (StringUtils.isEmptyOrWhitespace(varStr)) {
            throw new TemplateProcessingException("参数不能为空！");
        }
        if ("title".equals(varStr)) { // 标题
            result = globalConfig.getTitle();
        } else if ("title_full".equals(varStr)) { // 标题
            result = globalConfig.getTitleFull();
        } else if ("copy_info".equals(varStr)) { // 版权信息
            result = globalConfig.getCopyInfo();
        } else if ("domain_name".equals(varStr)) { // 域名
            result = globalConfig.getCopyInfo();
        } else if ("icp".equals(varStr)) { // ICP信息
            result = globalConfig.getIcp();
        } else if ("meta_keywords".equals(varStr)) { // SEO关键字
            result = globalConfig.getSeoKeywords();
        } else if ("meta_description".equals(varStr)) { // SEO描述
            result = globalConfig.getSeoDescription();
        } else if ("version".equals(varStr)) { // 版本号
            result = globalConfig.getSysVersion();
        }
        structureHandler.setBody(result, false);
    }
}
