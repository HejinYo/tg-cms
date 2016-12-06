package com.turingoal.cms.modules.plug.web.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.plug.domain.Resume;
import com.turingoal.cms.modules.plug.domain.query.ResumeQuery;
import com.turingoal.cms.modules.plug.service.ResumeService;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.bean.PageGridBean;
import com.turingoal.common.constants.ConstantPattern4Date;
import com.turingoal.common.exception.BusinessException;

/**
 * 招聘Controller
 */
@Controller
@RequestMapping("/m/plug/resume")
public class ResumeController {

    private static final String LIST_PAGE = "modules/plug/resume/list";
    private static final String SHOW_PAGE = "modules/plug/resume/show";

    @Autowired
    private ResumeService resumeService;

    /**
     * 返回招聘信息查询界面
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.GET)
    public String listPage() throws BusinessException {
        return LIST_PAGE;
    }

    /**
     * 返回招聘查询信息
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.POST)
    @ResponseBody
    public PageGridBean list(final ResumeQuery query) throws BusinessException {
        Page<Resume> result = resumeService.findByPage(query);
        return new PageGridBean(query, result, true);
    }

    /**
     * 返回招聘信息修改界面
     */
    @RequestMapping(value = "/show_{id}.gsp", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView(SHOW_PAGE);
        mav.addObject("result", resumeService.get(id));
        return mav;
    }

    /**
     * 根据id删除招聘信息
     */
    @RequestMapping(value = "/delete_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean delete(@PathVariable("id") final String id) throws BusinessException {
        resumeService.delete(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id启用 招聘信息
     */
    @RequestMapping(value = "/enable_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean enable(@RequestParam("id") final String id) throws BusinessException {
        resumeService.enable(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id停用招聘信息
     */
    @RequestMapping(value = "/disable_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean disable(@RequestParam("id") final String id) throws BusinessException {
        resumeService.disable(id);
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