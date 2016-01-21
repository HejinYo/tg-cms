package com.turingoal.cms.modules.base.web.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.turingoal.cms.modules.base.domain.CmsFile;
import com.turingoal.cms.modules.base.domain.form.CmsFileForm;
import com.turingoal.cms.modules.base.domain.query.CmsFileQuery;
import com.turingoal.cms.modules.base.service.CmsFileService;
import com.turingoal.common.bean.FileUploadBean;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.bean.PageGridBean;
import com.turingoal.common.constants.ConstantDateFormatTypes;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.util.io.JsonUtil;

/**
 * Controller-文件
 */
@Controller
@RequestMapping("/m/base/file")
public class CmsFileController {

    private static final String LIST_PAGE = "modules/material/file/list";

    @Autowired
    private CmsFileService fileService;

    /**
     * 文件上传页面
     */
    @RequestMapping(value = "/fileUpload.gsp", method = RequestMethod.GET)
    public final ModelAndView addPage() {
        ModelAndView mav = new ModelAndView("common/fileUpload");
        mav.addObject("upType", "file");
        return mav;
    }

    /**
     * findByIds 根据多个id获取
     */
    @RequestMapping(value = "/findByIds.gsp")
    @ResponseBody
    public JsonResultBean findByIds(@RequestParam("ids") final String ids) throws BusinessException {
        return new JsonResultBean(fileService.findByIds(ids));
    }

    /**
     * 返回文件查询界面
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.GET)
    public ModelAndView listPage() throws BusinessException {
        ModelAndView mav = new ModelAndView(LIST_PAGE);
        mav.addObject("format", fileService.findFormat());
        return mav;
    }

    /**
     * 分页查询 文件
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.POST)
    @ResponseBody
    public PageGridBean findByPage(final CmsFileQuery query) throws BusinessException {
        Page<CmsFile> result = fileService.findByPage(query);
        return new PageGridBean(query, result, true);
    }

    /**
     * 单文件上传
     */
    @RequestMapping(value = "/uploadFile.gsp")
    @ResponseBody
    public void singleFile(final FileUploadBean uploadItem, final CmsFileForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        CmsFileForm cmsFileForm = fileService.add(uploadItem, form, request);
        response.setContentType("text/html;charset=UTF-8");
        JsonResultBean result = new JsonResultBean(cmsFileForm.getId());
        try {
            response.setCharacterEncoding("utf-8");
            PrintWriter writer = response.getWriter();
            writer.write(JsonUtil.object2Json(result));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询全部 File
     */
    @RequestMapping(value = "/getFileByIds")
    @ResponseBody
    public Object findAll(final CmsFileQuery query) throws BusinessException {
        return fileService.findAll(query);
    }

    /**
     * 通过id得到一个 File
     */
    @RequestMapping(value = "/get")
    @ResponseBody
    public Object get(@RequestParam("id") final String id) throws BusinessException {
        return fileService.get(id);
    }

    /**
     * 根据id删除 File
     */
    @RequestMapping(value = "/delete_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean deleteById(@PathVariable("id") final String id) throws BusinessException {
        fileService.delete(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
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