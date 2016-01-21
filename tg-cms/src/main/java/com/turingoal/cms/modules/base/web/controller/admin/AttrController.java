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
import com.turingoal.cms.modules.base.domain.Attr;
import com.turingoal.cms.modules.base.domain.form.AttrForm;
import com.turingoal.cms.modules.base.domain.query.AttrQuery;
import com.turingoal.cms.modules.base.service.AttrService;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.bean.PageGridBean;
import com.turingoal.common.constants.ConstantDateFormatTypes;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.util.spring.SpringBindingResultWrapper;
import com.turingoal.common.util.validator.ValidGroupAdd;
import com.turingoal.common.util.validator.ValidGroupUpdate;

/**
 * 文章属性Controller
 */
@Controller
@RequestMapping("/m/base/attr")
public class AttrController {
    private static final String LIST_PAGE = "modules/config/attr/list";
    private static final String ADD_PAGE = "modules/config/attr/add";
    private static final String EDIT_PAGE = "modules/config/attr/edit";

    @Autowired
    private AttrService attrService;

    /**
     * 文章属性列表页面
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.GET)
    public final String listPage() throws BusinessException {
        return LIST_PAGE;
    }

    /**
     * 查询全部 文章属性
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final PageGridBean list(final AttrQuery query) throws BusinessException {
        List<Attr> result = attrService.findAll(query);
        return new PageGridBean(result);
    }

    /**
     * 新增页面
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.GET)
    public final String addPage() {
        return ADD_PAGE;
    }

    /**
     * 新增 文章属性
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean add(@Validated({ ValidGroupAdd.class }) @ModelAttribute("form") final AttrForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            attrService.add(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 修改页面
     */
    @RequestMapping(value = "/edit_{id}.gsp", method = RequestMethod.GET)
    public final ModelAndView editPage(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView(EDIT_PAGE);
        mav.addObject("result", attrService.get(id));
        return mav;
    }

    /**
     * 修改 文章属性
     */
    @RequestMapping(value = "/edit.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean update(@Validated({ ValidGroupUpdate.class }) @ModelAttribute("form") final AttrForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            attrService.update(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 根据id删除 文章属性
     */
    @RequestMapping(value = "/delete_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean deleteById(@PathVariable("id") final String id) throws BusinessException {
        attrService.delete(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 通过id得到一个 文章属性
     */
    @RequestMapping(value = "/get")
    public final Attr get(@RequestParam("id") final String id) throws BusinessException {
        return attrService.get(id);
    }

    /**
     * 根据文章id获取文章属性
     */
    @RequestMapping(value = "/findByInfoId.gsp")
    @ResponseBody
    public final JsonResultBean findByInfoId(@RequestParam("id") final String id) throws BusinessException {
        return new JsonResultBean(attrService.findByInfoId(id));
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