package com.turingoal.cms.modules.base.web.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.base.domain.Info;
import com.turingoal.cms.modules.base.domain.form.InfoForm;
import com.turingoal.cms.modules.base.domain.query.InfoQuery;
import com.turingoal.cms.modules.base.domain.query.NodeQuery;
import com.turingoal.cms.modules.base.service.InfoService;
import com.turingoal.cms.modules.base.service.NodeService;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.bean.PageGridBean;
import com.turingoal.common.constants.ConstantPattern4Date;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.util.net.RequestUtil;
import com.turingoal.common.support.validator.ValidGroupAdd;
import com.turingoal.common.support.validator.ValidGroupUpdate;

/**
 * 文章Controller
 */
@Controller
@RequestMapping("/m/base/info")
public class InfoController {
    private static final String LIST_PAGE = "modules/content/info/list";
    private static final String ADD_PAGE = "modules/content/info/add";
    private static final String EDIT_PAGE = "modules/content/info/edit";
    private static final String ADD_FOR_NODE_PAGE = "modules/content/info/addForNode";
    private static final String INFO_LIST_PAGE = "modules/content/info/infoList";
    @Autowired
    private InfoService infoService;
    @Autowired
    private NodeService nodeService;

    /**
     * 文章列表页面
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.GET)
    public final ModelAndView listPage() throws BusinessException {
        ModelAndView mav = new ModelAndView(LIST_PAGE);
        return mav;
    }

    /**
     * 文章列表页面
     */
    @RequestMapping(value = "/infoList.gsp", method = RequestMethod.GET)
    public final ModelAndView infoListPage(final InfoQuery query) throws BusinessException {
        ModelAndView mav = new ModelAndView(INFO_LIST_PAGE);
        if ("0".equals(query.getNodeId())) {
            query.setNodeId(null);
        }
        List<Info> result = infoService.findAll(query);
        mav.addObject("result", result);
        mav.addObject("nodeId", query.getNodeId());
        return mav;
    }

    /**
     * 分页查询 文章
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final PageGridBean findByPage(final InfoQuery query) throws BusinessException {
        Page<Info> result = infoService.findByPage(query);
        return new PageGridBean(query, result, true);
    }

    /**
     * 新增页面
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.GET)
    public final ModelAndView addPage() {
        ModelAndView mav = new ModelAndView(ADD_PAGE);
        mav.addObject("nodes", nodeService.findAll(new NodeQuery()));
        return mav;
    }

    /**
     * 新增页面
     */
    @RequestMapping(value = "/add_{nodeId}.gsp", method = RequestMethod.GET)
    public final ModelAndView addPageForNode(@PathVariable("nodeId") final String nodeId) {
        ModelAndView mav = new ModelAndView(ADD_FOR_NODE_PAGE);
        mav.addObject("node", nodeService.get(nodeId));
        return mav;
    }

    /**
     * 新增 Info
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.POST)
    public final String add(@Validated({ ValidGroupAdd.class }) @ModelAttribute("form") final InfoForm form, final BindingResult bindingResult, final HttpServletRequest request) throws BusinessException {
        infoService.add(form, RequestUtil.getRequestMapWithPrefix(request, "cus_"));
        return "redirect:/admin/m/base/info/list.gsp";
    }

    /**
     * 修改页面
     */
    @RequestMapping(value = "/edit_{id}.gsp", method = RequestMethod.GET)
    public final ModelAndView editPage(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView(EDIT_PAGE);
        mav.addObject("result", infoService.get(id));
        return mav;
    }

    /**
     * 修改 文章
     */
    @RequestMapping(value = "/edit.gsp", method = RequestMethod.POST)
    public final String update(@Validated({ ValidGroupUpdate.class }) @ModelAttribute("form") final InfoForm form, final BindingResult bindingResult, final HttpServletRequest request) throws BusinessException {
        infoService.update(form, RequestUtil.getRequestMapWithPrefix(request, "cus_"));
        return "redirect:/admin/m/base/info/list.gsp";
    }

    /**
     * 根据id删除 文章
     */
    @RequestMapping(value = "/delete_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean deleteById(@PathVariable("id") final String id) throws BusinessException {
        infoService.delete(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 审核通过
     */
    @RequestMapping(value = "/passInfo")
    @ResponseBody
    public final JsonResultBean passInfo(@RequestParam("id") final String id) throws BusinessException {
        infoService.updatePassInfo(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 退稿/退回/审核通过
     */
    @RequestMapping(value = "/backInfo")
    @ResponseBody
    public final JsonResultBean backInfo(@RequestParam("id") final String id) throws BusinessException {
        infoService.updateBackInfo(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 通过id得到一个 文章
     */
    @RequestMapping(value = "/get")
    @ResponseBody
    public final Info get(@RequestParam("id") final String id) throws BusinessException {
        return infoService.get(id);
    }

    /**
     * 将form表单里面的String Date转换成Date型，字符串去掉空白
     */
    @InitBinder
    protected final void initBinder(final HttpServletRequest request, final ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(ConstantPattern4Date.YYYY_MM_DD), true));
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}