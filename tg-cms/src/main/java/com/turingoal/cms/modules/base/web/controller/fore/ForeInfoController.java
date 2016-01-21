package com.turingoal.cms.modules.base.web.controller.fore;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.turingoal.cms.core.service.SysSensitiveWordService;
import com.turingoal.cms.modules.base.domain.Info;
import com.turingoal.cms.modules.base.domain.Node;
import com.turingoal.cms.modules.base.service.CmsFileService;
import com.turingoal.cms.modules.base.service.InfoService;
import com.turingoal.cms.modules.base.service.NodeService;
import com.turingoal.common.util.lang.StringUtil;

/**
 * Controller-文章
 */
@Controller
public class ForeInfoController {
    @Autowired
    private InfoService infoService;
    @Autowired
    private NodeService nodeService;
    @Autowired
    private CmsFileService fileService;
    @Autowired
    private TemplateEngineHelper templateEngineHelper;
    @Autowired
    private SysSensitiveWordService sensitiveWordService;

    /**
     * 文章页
     */
    @RequestMapping("/info_{infoId}.htm")
    public void index(@PathVariable final String infoId, final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        Info info = infoService.get(infoId);
        // 屏蔽关键字
        info.setInfoText(sensitiveWordService.replace(info.getInfoText()));
        Node node = nodeService.get(info.getNodeId());
        request.setAttribute("id", infoId);
        request.setAttribute("codeNum", node.getCodeNum());
        request.setAttribute("curr", node);
        request.setAttribute("info", info);
        infoService.updateViewsCount(infoId);

        String temolateName = StringUtil.isNullOrEmpty(node.getInfoTemplate()) ? "default/models/contact_info" : node.getInfoTemplate();
        templateEngineHelper.process(temolateName, request, response);
        return;
    }

    /**
     * 单文件下载
     */
    @RequestMapping(value = "/downFile.htm")
    public void downFile(@RequestParam final String ids, final HttpServletResponse response) throws FileNotFoundException {
        fileService.downFile(ids, response);
        // return;
    }
}