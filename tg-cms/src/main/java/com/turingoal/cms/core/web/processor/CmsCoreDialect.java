package com.turingoal.cms.core.web.processor;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.context.IContext;
import org.thymeleaf.context.IProcessingContext;
import org.thymeleaf.context.IWebContext;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionEnhancingDialect;
import org.thymeleaf.processor.IProcessor;
import com.turingoal.cms.core.web.directive.CheckAuthDirective;

/**
 * 标签
 */
public class CmsCoreDialect extends AbstractDialect implements IExpressionEnhancingDialect {
    public static final String DEFAULT_PREFIX = "giCore";
    public static final String CORE_OBJECT_CHECKAUTH = "checkAuth";

    @Autowired
    private CheckAuthDirective checkAuthDirective;

    public CmsCoreDialect() {
        super();
    }

    public String getPrefix() {
        return DEFAULT_PREFIX;
    }

    public boolean isLenient() {
        return false;
    }

    @Override
    public Set<IProcessor> getProcessors() {
        final Set<IProcessor> processors = new LinkedHashSet<IProcessor>();
        return processors;
    }

    /**
     * 自定义
     */
    public Map<String, Object> getAdditionalExpressionObjects(final IProcessingContext processingContext) {
        final IContext context = processingContext.getContext();
        final IWebContext webContext = (context instanceof IWebContext ? (IWebContext) context : null);
        final Map<String, Object> objects = new HashMap<String, Object>(3, 1.0f);
        // objects
        if (webContext != null) {
            final HttpServletRequest request = webContext.getHttpServletRequest();
            final HttpServletResponse response = webContext.getHttpServletResponse();
            final ServletContext servletContext = webContext.getServletContext();
            if (request != null && response != null && servletContext != null) {
                objects.put(CORE_OBJECT_CHECKAUTH, checkAuthDirective); // query
            }
        }
        return objects;
    }
}
