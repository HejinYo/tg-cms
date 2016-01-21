package com.turingoal.cms.modules.plug.web.processor;

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
import com.turingoal.cms.modules.plug.web.directive.ResumeDirective;

/**
 * 标签
 */
public class CmsPlugDialect extends AbstractDialect implements IExpressionEnhancingDialect {
    public static final String DEFAULT_PREFIX = "giPlug";
    public static final String RESUME_OBJECT_NAME = "resume";

    @Autowired
    private ResumeDirective directive;

    public CmsPlugDialect() {
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
     * 添加标签
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
                objects.put(RESUME_OBJECT_NAME, directive); // resume
            }
        }
        return objects;
    }
}
