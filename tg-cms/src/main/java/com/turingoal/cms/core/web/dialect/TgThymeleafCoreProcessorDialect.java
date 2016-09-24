package com.turingoal.cms.core.web.dialect;

import java.util.HashSet;
import java.util.Set;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;
import com.turingoal.common.support.thymeleaf.PrettytimeProcessor;
import com.turingoal.common.support.thymeleaf.SensitiveWordProcessor;

/**
 * Turingoal core 自定义方言
 */
public class TgThymeleafCoreProcessorDialect extends AbstractProcessorDialect {
    private static final String DIALECT_NAME = "Turingoal Dialect core"; // 方言名称需要唯一。自定义方言名称Turingoal Dialect core
    public static final String DIALECT_PREFIX = "tg_core"; // 前缀

    public TgThymeleafCoreProcessorDialect() {
        super(DIALECT_NAME, DIALECT_PREFIX, StandardDialect.PROCESSOR_PRECEDENCE);
    }

    /**
     * 自定义的Processor在这里添加
     */
    public Set<IProcessor> getProcessors(final String dialectPrefix) {
        final Set<IProcessor> processors = new HashSet<IProcessor>();
        processors.add(new PremissionProcessor()); // 授权premissionProcessor
        processors.add(new SensitiveWordProcessor()); // 敏感词premissionProcessor
        processors.add(new PrettytimeProcessor()); // 日期美化 Processor
        return processors;
    }
}
