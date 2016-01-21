package com.turingoal.cms.core.commons;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.access.AccessDeniedHandler;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.util.net.RequestUtil;
import com.turingoal.common.util.net.WebUtils;

/**
 * 在Spring默认的AccessDeniedHandler中只有对页面请求的处理，而没有对Ajax的处理。而在项目开发是Ajax又是我们要常用的技术，所以我们可以通过自定义AccessDeniedHandler来处理Ajax请求
 */
public class TgSecurityAccessDeniedHandler implements AccessDeniedHandler {
    private String accessDeniedUrl;  // 跳转到的错误页面

    public TgSecurityAccessDeniedHandler() {
        super();
    }

    public TgSecurityAccessDeniedHandler(final String accessDeniedUrlParm) {
        this.accessDeniedUrl = accessDeniedUrlParm;
    }

    @Override
    public void handle(final HttpServletRequest request, final HttpServletResponse response, final AccessDeniedException accessDeniedException) throws IOException, ServletException {
        boolean isAjax = RequestUtil.isAjax(request);
        // 判断是否是ajax请求
        if (isAjax) {
            WebUtils.writeToBrowser(new JsonResultBean(accessDeniedException).toString(), response);
        } else if (!response.isCommitted()) {
            if (accessDeniedUrl != null) {
                // 将异常放入到request
                request.setAttribute(WebAttributes.ACCESS_DENIED_403, accessDeniedException);
                // 设置 403状态
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                // forward 到 error page.
                RequestDispatcher dispatcher = request.getRequestDispatcher(accessDeniedUrl);
                dispatcher.forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, accessDeniedException.getMessage());
            }
        }
    }

    /**
     * 设置跳转到的错误页面
     */
    public void setAccessDeniedUrl(final String accessDeniedUrlParm) {
        if ((accessDeniedUrlParm != null) && !accessDeniedUrlParm.startsWith("/")) {
            throw new IllegalArgumentException("跳转到错误页面必须以 '/' 开头");
        }
        this.accessDeniedUrl = accessDeniedUrlParm;
    }
}
