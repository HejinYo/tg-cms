package com.turingoal.cms.core.web.controller.admin;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.turingoal.cms.core.domain.form.GlobalForm;
import com.turingoal.cms.core.service.GlobalService;
import com.turingoal.common.constants.ConstantPattern4Date;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.support.validator.ValidGroupUpdate;

/**
 * 全局参数Controller
 */
@Controller
@RequestMapping("/c/global")
public class GlobalController {
    private static final String LIST_PAGE = "modules/config/global/list";

    @Autowired
    private GlobalService globalService;

    /**
     * 列表页面
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.GET)
    public final ModelAndView list() {
        ModelAndView mav = new ModelAndView(LIST_PAGE);
        /*
         * List<Global> result = globalService.find(query); mav.addObject("globalList", result);
         */
        mav.addObject("result", globalService.get());
        return mav;
    }

    /**
     * 修改 全局参数
     */
    @RequestMapping(value = "/edit.gsp", method = RequestMethod.POST)
    public final String update(@Validated({ ValidGroupUpdate.class }) @ModelAttribute("form") final GlobalForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        /*
         * if (bindingResult.hasErrors()) { String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult); return new JsonResultBean(JsonResultBean.FAULT, errorMsg); } else { globalService.update(form); return new JsonResultBean(JsonResultBean.SUCCESS); }
         */
        globalService.update(form);
        return "redirect:/admin/m/base/global/list.gsp";
    }

    /**
     * 获得主题名称
     */
    @RequestMapping(value = "/getThemes.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final List<String> getThemes(final HttpServletRequest request) {
        String path = request.getServletContext().getRealPath("/template/");
        File file = new File(path);
        File[] themeList = file.listFiles();
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < themeList.length; i++) {
            if (themeList[i].isDirectory()) {
                list.add(themeList[i].getName());
            }           
        }
        return list;
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