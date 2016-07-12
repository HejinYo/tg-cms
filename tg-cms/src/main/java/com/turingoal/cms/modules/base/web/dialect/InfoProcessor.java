package com.turingoal.cms.modules.base.web.dialect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.exceptions.TemplateProcessingException;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.util.StringUtils;
import com.turingoal.cms.modules.base.service.InfoService;
import jodd.util.StringUtil;

/**
 * 文章Processor
 */
@Component
public class InfoProcessor extends AbstractAttributeTagProcessor {
    public static final int PRECEDENCE = 10000; // 优先级
    public static final String DEFAULT_DIALECT_PREFIX = "tg_cms"; // 默认前缀
    public static final String ATTR_NAME = "info"; // 属性名称
    public static final String STATUS_VAR_NAME = "info";
    @Autowired
    private InfoService infoService;

    public InfoProcessor() {
        super(TemplateMode.HTML, DEFAULT_DIALECT_PREFIX, null, false, ATTR_NAME, true, PRECEDENCE, true);
    }

    /**
     * 处理标签
     */
    @Override
    protected void doProcess(final ITemplateContext context, final IProcessableElementTag tag, final AttributeName attributeName, final String attributeValue, final IElementTagStructureHandler structureHandler) {
        String varStr = attributeValue.trim(); // 获取参数
        if (StringUtils.isEmptyOrWhitespace(varStr)) {
            throw new TemplateProcessingException("参数不能为空！");
        }
        String[] vars = StringUtil.split(attributeValue, ",");
        String iterVarName = vars[0]; // 迭代变量
        String infoId = null;
        if (vars.length > 1) {
            if (!"root".equals(vars[1])) {
                infoId = vars[1]; // 文章id
            }
        }
        Object iteratedValue = infoService.get(infoId); // 数据
        structureHandler.iterateElement(iterVarName, STATUS_VAR_NAME, iteratedValue);
    }
}
