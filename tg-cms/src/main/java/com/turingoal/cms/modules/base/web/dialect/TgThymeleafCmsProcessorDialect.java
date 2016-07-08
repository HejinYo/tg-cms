package com.turingoal.cms.modules.base.web.dialect;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;
import com.turingoal.cms.modules.ext.web.dialect.FrendlinkListProcessor;

/**
 * Turingoal CMS自定义方言
 */
public class TgThymeleafCmsProcessorDialect extends AbstractProcessorDialect {
    private static final String DIALECT_NAME = "Turingoal Dialect CMS"; // 方言名称需要唯一。自定义方言名称Turingoal Dialect CMS
    public static final String DIALECT_PREFIX = "tg_cms"; // 前缀
    @Autowired
    private NodeListProcessor nodeListProcessor; // 栏目
    @Autowired
    private FrendlinkListProcessor frendlinkListProcessor; // 友情链接

    public TgThymeleafCmsProcessorDialect() {
        super(DIALECT_NAME, DIALECT_PREFIX, StandardDialect.PROCESSOR_PRECEDENCE);
    }

    /**
     * 自定义的Processor在这里添加
     */
    public Set<IProcessor> getProcessors(final String dialectPrefix) {
        final Set<IProcessor> processors = new HashSet<IProcessor>();
        processors.add(nodeListProcessor);
        processors.add(frendlinkListProcessor);
        return processors;
    }
}
