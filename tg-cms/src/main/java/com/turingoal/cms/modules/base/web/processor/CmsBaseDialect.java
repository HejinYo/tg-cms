package com.turingoal.cms.modules.base.web.processor;

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
import com.turingoal.cms.modules.base.web.directive.CommentDirective;
import com.turingoal.cms.modules.base.web.directive.InfoDirective;
import com.turingoal.cms.modules.base.web.directive.NodeDirective;
import com.turingoal.cms.modules.base.web.directive.QueryDirective;
import com.turingoal.cms.modules.base.web.directive.SpecialDirective;
import com.turingoal.cms.modules.base.web.directive.TagDirective;

/**
 * 标签
 */
public class CmsBaseDialect extends AbstractDialect implements IExpressionEnhancingDialect {
    public static final String DEFAULT_PREFIX = "giBase";
    public static final String QUERY_OBJECT_NAME = "query"; // sql查询
    public static final String INFO_OBJECT_NAME = "INFO"; // 文章
    public static final String NODE_OBJECT_NAME = "NODE"; // 栏目
    public static final String SPECIAL_OBJECT_NAME = "SPECIAL"; // 专题
    public static final String COMMENT_OBJECT_NAME = "COMMENT"; // 评论
    public static final String TAG_OBJECT_NAME = "TAG"; // TAG

    @Autowired
    private CommentDirective commentDirective;
    @Autowired
    private InfoDirective infoDirective;
    @Autowired
    private NodeDirective nodeDirective;
    @Autowired
    private QueryDirective queryDirective;
    @Autowired
    private SpecialDirective specialDirective;
    @Autowired
    private TagDirective tagDirective;

    public CmsBaseDialect() {
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
                objects.put(QUERY_OBJECT_NAME, queryDirective); // query
                objects.put(INFO_OBJECT_NAME, infoDirective); // info
                objects.put(NODE_OBJECT_NAME, nodeDirective); // node
                objects.put(SPECIAL_OBJECT_NAME, specialDirective); // special
                objects.put(COMMENT_OBJECT_NAME, commentDirective); // comment
                objects.put(TAG_OBJECT_NAME, tagDirective); // tag
            }
        }
        return objects;
    }
}
