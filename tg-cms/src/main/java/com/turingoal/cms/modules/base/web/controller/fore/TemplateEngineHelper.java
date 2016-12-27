package com.turingoal.cms.modules.base.web.controller.fore;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring4.SpringTemplateEngine;
import com.turingoal.cms.modules.base.service.GlobalService;
import com.turingoal.cms.modules.base.service.TemplateService;
import com.turingoal.common.util.net.WebUtils;

/**
 * 模板
 */
@Component
public final class TemplateEngineHelper {
    @Value("${system.htmlPath}")
    private String htmlPath; // 静态页面路径
    @Autowired
    private SpringTemplateEngine templateEngine;
    @Autowired
    private TemplateService templateService;
    @Autowired
    private GlobalService globalService;

    /**
     * 解析模板
     */
    public void process(final String templateName, final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        // if (SystemHelper.getGlobal() == null) {
        // List<Global> gs = globalService.findAll(new GlobalQuery());
        /// SystemHelper.setGlobal(gs.get(0));
        // }
        // Template template = templateService.get(""); // 此处应获取当前启用的模板
        String templateCodeNum = "green"; // 默认模板
        // if (template != null) {
        // templateCodeNum = template.getCodeNum();
        // }
        String tempName = templateName;
        // if ("index".equals(templateName) || "search".equals(templateName)) {
        tempName = templateCodeNum + "/" + templateName;
        // }
        response.setContentType("text/html; charset=utf-8"); // 不加这行谷歌会出现乱码
        WebContext ctx = new WebContext(request, response, request.getServletContext(), request.getLocale());
        String content = templateEngine.process(tempName, ctx); // 生成页面内容
        // 这需要替换敏感字......
        WebUtils.writeToBrowser(content, response);
    }
}
