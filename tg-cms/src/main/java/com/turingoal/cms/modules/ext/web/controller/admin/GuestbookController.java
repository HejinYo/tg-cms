package com.turingoal.cms.modules.ext.web.controller.admin;

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
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.ext.domain.Guestbook;
import com.turingoal.cms.modules.ext.domain.form.GuestbookForm;
import com.turingoal.cms.modules.ext.domain.query.GuestbookQuery;
import com.turingoal.cms.modules.ext.domain.query.GuestbookTypeQuery;
import com.turingoal.cms.modules.ext.service.GuestbookService;
import com.turingoal.cms.modules.ext.service.GuestbookTypeService;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.bean.PageGridBean;
import com.turingoal.common.constants.ConstantPattern4Date;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.support.spring.SpringBindingResultWrapper;
import com.turingoal.common.support.validator.ValidGroupAdd;
import com.turingoal.common.support.validator.ValidGroupUpdate;

/**
 * 留言信息Controller
 */
@Controller
@RequestMapping("/m/ext/guestbook")
public class GuestbookController {

    private static final String LIST_PAGE = "modules/content/guestbook/list";
    private static final String EDIT_PAGE = "modules/content/guestbook/edit";

    @Autowired
    private GuestbookService guestbookService;
    @Autowired
    private GuestbookTypeService guestbookTypeService;

    /**
     * 返回留言信息查询界面
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.GET)
    public ModelAndView listPage() throws BusinessException {
        ModelAndView mav = new ModelAndView(LIST_PAGE);
        GuestbookTypeQuery query = new GuestbookTypeQuery();
        mav.addObject("guestbookType", guestbookTypeService.findAll(query));
        return mav;
    }

    /**
     * 返回留言查询信息
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.POST)
    @ResponseBody
    public PageGridBean list(final GuestbookQuery query) throws BusinessException {
        Page<Guestbook> result = guestbookService.findByPage(query);
        return new PageGridBean(query, result, true);
    }

    /**
     * 通过id得到一个 留言
     */
    @RequestMapping(value = "/get.gsp")
    @ResponseBody
    public Object get(@RequestParam("id") final String id) throws BusinessException {
        return guestbookService.get(id);
    }

    /**
     * 新增 Guestbook
     */
    @RequestMapping(value = "/add")
    public final JsonResultBean add(@Validated({ ValidGroupAdd.class }) @ModelAttribute("form") final GuestbookForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            guestbookService.add(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 返回留言信息回复修改界面
     */
    @RequestMapping(value = "/edit_{id}.gsp", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView(EDIT_PAGE);
        mav.addObject("result", guestbookService.get(id));
        return mav;
    }

    /**
     * 回复修改 留言信息
     */
    @RequestMapping(value = "/edit.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean update(@Validated({ ValidGroupUpdate.class }) @ModelAttribute("form") final GuestbookForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            guestbookService.update(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 根据id删除 Guestbook
     */
    @RequestMapping(value = "/delete_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean delete(@PathVariable("id") final String id) throws BusinessException {
        guestbookService.delete(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id启用 Guestbook
     */
    @RequestMapping(value = "/enable")
    @ResponseBody
    public final JsonResultBean enable(@RequestParam("id") final String id) throws BusinessException {
        guestbookService.enable(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id停用 Guestbook
     */
    @RequestMapping(value = "/disable")
    @ResponseBody
    public final JsonResultBean disable(@RequestParam("id") final String id) throws BusinessException {
        guestbookService.disable(id);
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