package com.turingoal.cms.modules.ext.web.dialect;

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
import com.turingoal.cms.modules.ext.domain.query.AdQuery;
import com.turingoal.cms.modules.ext.service.AdService;
import jodd.util.StringUtil;

/**
 * 广告Processor
 */
@Component
public class AdProcessor extends AbstractAttributeTagProcessor {
    public static final int PRECEDENCE = 10000; // 优先级
    public static final String DEFAULT_DIALECT_PREFIX = "tg_cms"; // 默认前缀
    public static final String ATTR_NAME = "ad"; // 属性名称
    public static final String STATUS_VAR_NAME = "itemStat";
    @Autowired
    private AdService adService;

    public AdProcessor() {
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
        AdQuery query = new AdQuery();
        String[] vars = StringUtil.split(attributeValue, ",");
        String iterVarName = vars[0]; // 迭代变量
        if (vars.length > 1) {
            query.setAdSlotCodeNum(vars[1]); // 广告位
        }
        if (vars.length > 2) {
            query.setLimit(Long.valueOf(vars[2])); // 最大数量
        }
        Object iteratedValue = adService.findBySlot(query); // 数据集
        structureHandler.iterateElement(iterVarName, STATUS_VAR_NAME, iteratedValue);
    }
}
