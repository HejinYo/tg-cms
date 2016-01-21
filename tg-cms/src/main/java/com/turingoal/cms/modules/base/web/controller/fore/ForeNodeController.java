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
 * Controller-栏目
 */
@Controller
public class ForeNodeController {
    @Autowired
    private NodeService nodeService;
    @Autowired
    private TemplateEngineHelper templateEngineHelper;

    /**
     * 栏目
     */
    @RequestMapping("/{codeNum}_{page:[0-9]*}.htm")
    public void nodePageByPage(@PathVariable final String codeNum, @PathVariable final Integer page, final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        int pageNum = (page != null && page > 0) ? page : 1;
        Node node = nodeService.getByCode(codeNum);
        request.setAttribute("curr", node);
        request.setAttribute("codeNum", codeNum);
        request.setAttribute("page", pageNum);

        String temolateName = "default/models/list";
        if (node != null) {
            temolateName = StringUtil.isNullOrEmpty(node.getNodeTemplate()) ? "default/models/list" : node.getNodeTemplate();
        }
        templateEngineHelper.process(temolateName, request, response);
        return;
    }

    /**
     * 将form表单里面的字符串去掉空白
     */
    @InitBinder
    protected void initBinder(final HttpServletRequest request, final ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}