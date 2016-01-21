package com.turingoal.cms.core.commons;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * 文件上传控制
 */
public class TgMultipartResolver extends CommonsMultipartResolver {
    private String excludeUrl;

    public String getExcludeUrl() {
        return excludeUrl;
    }

    public void setExcludeUrl(final String excludeUrlParm) {
        this.excludeUrl = excludeUrlParm;
    }

    @Override
    public boolean isMultipart(final HttpServletRequest request) {
        if (request.getRequestURI().contains(excludeUrl)) {
            return false;
        }
        return super.isMultipart(request);
    }
}
