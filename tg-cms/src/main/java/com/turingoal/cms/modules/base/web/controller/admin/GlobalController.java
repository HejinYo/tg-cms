package com.turingoal.cms.modules.base.web.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.turingoal.cms.modules.base.domain.Global;
import com.turingoal.cms.modules.base.domain.form.GlobalForm;
import com.turingoal.cms.modules.base.domain.query.GlobalQuery;
import com.turingoal.cms.modules.base.service.GlobalService;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.constants.ConstantDateFormatTypes;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.util.spring.SpringBindingResultWrapper;
import com.turingoal.common.util.validator.ValidGroupAdd;
import com.turingoal.common.util.validator.ValidGroupUpdate;

/**
 * 全局参数Controller
 */
@Controller
@RequestMapping("/m/base/global")
public class GlobalController {
    private static final  String LIST_PAGE = "modules/config/global/list";
    private static final  String ADD_PAGE = "modules/config/global/add";
    private static final  String EDIT_PAGE = "modules/config/global/edit";

    @Autowired
    private GlobalService globalService;

    /**
     * 全局参数列表页面
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.GET)
    public final ModelAndView listPage(final GlobalQuery query) throws BusinessException {
        ModelAndView mav = new ModelAndView(LIST_PAGE);
        mav.addObject("result", globalService.findAll(query).get(0));
        return mav;
    }

    /**
     * 查询全部 全局参数
     */
    /*@RequestMapping(value = "/list.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final List<Global> findAll(final GlobalQuery query) throws BusinessException {
        return globalService.findAll(query);
    }*/

    /**
     * 新增页面
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.GET)
    public final String addPage() {
        return ADD_PAGE;
    }

    /**
     * 新增 全局参数
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean add(@Validated({ ValidGroupAdd.class }) @ModelAttribute("form") final GlobalForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            globalService.add(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 修改页面
     */
    @RequestMapping(value = "/edit_{id}.gsp", method = RequestMethod.GET)
    public final ModelAndView editPage(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView(EDIT_PAGE);
        mav.addObject("result", globalService.get(id));
        return mav;
    }

    /**
     * 修改 全局参数
     */
    @RequestMapping(value = "/edit.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean update(@Validated({ ValidGroupUpdate.class }) @ModelAttribute("form") final GlobalForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            globalService.update(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 通过id得到一个 全局参数
     */
    @RequestMapping(value = "/get")
    @ResponseBody
    public final Global get(@RequestParam("id") final String id) throws BusinessException {
        return globalService.get(id);
    }

    /**
     * 将form表单里面的String Date转换成Date型，字符串去掉空白
     */
    @InitBinder
    protected final void initBinder(final HttpServletRequest request, final ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(ConstantDateFormatTypes.YYYY_MM_DD), true));
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}