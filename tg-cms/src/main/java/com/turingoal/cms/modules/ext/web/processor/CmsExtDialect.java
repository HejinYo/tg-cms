package com.turingoal.cms.modules.ext.web.processor;

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
import com.turingoal.cms.modules.ext.web.directive.FriendLinkDirective;
import com.turingoal.cms.modules.ext.web.directive.FriendLinkTypeDirective;
import com.turingoal.cms.modules.ext.web.directive.GuestbookDirective;
import com.turingoal.cms.modules.ext.web.directive.GuestbookTypeDirective;
import com.turingoal.cms.modules.ext.web.directive.VoteDirective;

/**
 * 标签
 */
public class CmsExtDialect extends AbstractDialect implements IExpressionEnhancingDialect {
    public static final String DEFAULT_PREFIX = "giExt";
    public static final String GBTYPE_OBJECT_NAME = "guestbookType";
    public static final String GB_OBJECT_NAME = "guestbook";
    public static final String FLTYPE_OBJECT_NAME = "friendlinkType";
    public static final String FL_OBJECT_NAME = "friendlink";
    public static final String VOTE_OBJECT_NAME = "vote";

    @Autowired
    private FriendLinkDirective friendLinkDirective;
    @Autowired
    private FriendLinkTypeDirective friendLinkTypeDirective;
    @Autowired
    private GuestbookDirective guestbookDirective;
    @Autowired
    private GuestbookTypeDirective guestbookTypeDirective;
    @Autowired
    private VoteDirective voteDirective;

    public CmsExtDialect() {
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
                objects.put(GBTYPE_OBJECT_NAME, guestbookTypeDirective); // guestbookType
                objects.put(GB_OBJECT_NAME, guestbookDirective); // guestbook
                objects.put(FLTYPE_OBJECT_NAME, friendLinkTypeDirective); // friendlinkType
                objects.put(FL_OBJECT_NAME, friendLinkDirective); // friendlink
                objects.put(VOTE_OBJECT_NAME, voteDirective); // vote
            }
        }
        return objects;
    }
}
