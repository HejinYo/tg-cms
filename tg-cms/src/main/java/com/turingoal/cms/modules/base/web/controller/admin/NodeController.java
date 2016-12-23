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
import com.turingoal.cms.modules.base.domain.Node;
import com.turingoal.cms.modules.base.domain.form.NodeForm;
import com.turingoal.cms.modules.base.domain.query.NodeQuery;
import com.turingoal.cms.modules.base.service.ModelService;
import com.turingoal.cms.modules.base.service.NodeService;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.bean.PageGridBean;
import com.turingoal.common.constants.ConstantPattern4Date;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.util.net.RequestUtil;
import com.turingoal.common.support.validator.ValidGroupAdd;
import com.turingoal.common.support.validator.ValidGroupUpdate;

/**
 * 栏目Controller
 */
@Controller
@RequestMapping("/m/base/node")
public class NodeController {
    private static final String LIST_PAGE = "modules/site/node/list";
    private static final String ADD_PAGE = "modules/site/node/add";
    private static final String EDIT_PAGE = "modules/site/node/edit";

    @Autowired
    private NodeService nodeService;
    @Autowired
    private ModelService modelService;

    /**
     * 栏目列表页面
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.GET)
    public final ModelAndView listPage(final NodeQuery query) throws BusinessException {
        ModelAndView mav = new ModelAndView(LIST_PAGE);
        List<Node> result = nodeService.findAll(query);
        mav.addObject("nodeList", result);
        return mav;
    }

    /**
     * 查询全部栏目
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.POST)
    @ResponseBody
    public PageGridBean findAll(final NodeQuery query) throws BusinessException {
        List<Node> result = nodeService.findAll(query);
        return new PageGridBean(result);
    }

    /**
     * 通过id得到一个 栏目
     */
    @RequestMapping(value = "/get")
    @ResponseBody
    public Object get(@RequestParam("id") final String id) throws BusinessException {
        return nodeService.get(id);
    }

    /**
     * 新增页面
     */
    @RequestMapping(value = "/add_{parendId}.gsp", method = RequestMethod.GET)
    public final ModelAndView addPage(@PathVariable final String parendId) {
        ModelAndView mav = new ModelAndView(ADD_PAGE);
        mav.addObject("nodeModels", modelService.findByType("node"));
        mav.addObject("infoModels", modelService.findByType("info"));
        mav.addObject("parendId", parendId);
        return mav;
    }

    /**
     * 新增 栏目
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.POST)
    public final String add(@Validated({ ValidGroupAdd.class }) @ModelAttribute("form") final NodeForm form, final BindingResult bindingResult, final HttpServletRequest request) throws BusinessException {
        /*
         * // 数据校验 if (bindingResult.hasErrors()) { String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult); return new JsonResultBean(JsonResultBean.FAULT, errorMsg); } else { nodeService.add(form, RequestUtil.getRequestMapWithPrefix(request, "cus_")); return new
         * JsonResultBean(JsonResultBean.SUCCESS); }
         */
        nodeService.add(form, RequestUtil.getRequestMapWithPrefix(request, "cus_"));
        return "rediect:/admin/m/base/node/list.gsp";
    }

    /**
     * 修改页面
     */
    @RequestMapping(value = "/edit_{id}.gsp", method = RequestMethod.GET)
    public final ModelAndView editPage(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView(EDIT_PAGE);
        mav.addObject("nodeModels", modelService.findByType("node"));
        mav.addObject("infoModels", modelService.findByType("info"));
        mav.addObject("result", nodeService.get(id));
        return mav;
    }

    /**
     * 修改 栏目
     */
    @RequestMapping(value = "/edit.gsp", method = RequestMethod.POST)
    public final String update(@Validated({ ValidGroupUpdate.class }) @ModelAttribute("form") final NodeForm form, final BindingResult bindingResult, final HttpServletRequest request) throws BusinessException {
        /*
         * // 数据校验 if (bindingResult.hasErrors()) { String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult); return new JsonResultBean(JsonResultBean.FAULT, errorMsg); } else { nodeService.update(form, RequestUtil.getRequestMapWithPrefix(request, "cus_")); return new
         * JsonResultBean(JsonResultBean.SUCCESS); }
         */
        nodeService.update(form, RequestUtil.getRequestMapWithPrefix(request, "cus_"));
        return "rediect:/admin/m/base/node/list.gsp";
    }

    /**
     * 根据id删除栏目
     */
    @RequestMapping(value = "/delete_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean deleteById(@PathVariable("id") final String id) throws BusinessException {
        String result = nodeService.delete(id);
        if (result == null) {
            return new JsonResultBean(JsonResultBean.SUCCESS);
        } else {
            return new JsonResultBean(JsonResultBean.FAULT, result);
        }
    }

    /**
     * 根据id启用 栏目
     */
    @RequestMapping(value = "/enable_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean enable(@PathVariable("id") final String id) throws BusinessException {
        nodeService.enable(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id停用 栏目
     */
    @RequestMapping(value = "/disable_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean disable(@PathVariable("id") final String id) throws BusinessException {
        nodeService.disable(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
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