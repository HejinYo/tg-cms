package com.turingoal.cms.modules.base.web.controller.fore;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.turingoal.cms.modules.base.domain.Node;
import com.turingoal.cms.modules.base.service.NodeService;
import com.turingoal.common.util.lang.StringUtil;

/**
 * 栏目Controller
 */
@Controller
public class ForeNodeController {
    @Autowired
    private NodeService nodeService;
    @Autowired
    private TemplateEngineHelper templateEngineHelper;
    private static String templateName = "default/models/list";

    /**
     * 栏目首页
     */
    @RequestMapping("/{codeNum}_index.htm")
    public void nodeIndex(@PathVariable final String codeNum, final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        Integer pageNum = 1;
        listByPage(codeNum, pageNum, request, response);
    }

    /**
     * 栏目文章列表页
     */
    @RequestMapping("/{codeNum}_{page:[0-9]*}.htm")
    public void listByPage(@PathVariable final String codeNum, @PathVariable final Integer page, final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        Integer pageNum = page;
        if (pageNum == null || pageNum < 1) {
            pageNum = 1;
        }
        Node node = nodeService.getByCode(codeNum);
        request.setAttribute("currentNode", node); // 当前栏目信息放入模板变量中
        request.setAttribute("codeNum", codeNum); // 当前栏目编码
        request.setAttribute("page", pageNum); // 当前栏目页数
        if (node != null) {
            if (!StringUtil.isNullOrEmpty(node.getNodeTemplate())) {
                templateName = node.getNodeTemplate(); // 栏目模板
            }
        }
        templateEngineHelper.process(templateName, request, response);
    }

    /**
     * 将form表单里面的字符串去掉空白
     */
    @InitBinder
    protected void initBinder(final HttpServletRequest request, final ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}