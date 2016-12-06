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
import com.turingoal.cms.modules.base.domain.CmsVideo;
import com.turingoal.cms.modules.base.domain.form.CmsVideoForm;
import com.turingoal.cms.modules.base.domain.query.CmsVideoQuery;
import com.turingoal.cms.modules.base.service.CmsVideoService;
import com.turingoal.common.bean.FileUploadBean;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.bean.PageGridBean;
import com.turingoal.common.constants.ConstantPattern4Date;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.util.io.JsonUtil;

/**
 * CmsVideoController
 */
@Controller
@RequestMapping("/m/base/video")
public class CmsVideoController {

    private static final String LIST_PAGE = "modules/material/video/list";
    private static final String SHOW_PAGE = "modules/material/video/show";

    @Autowired
    private CmsVideoService videoService;

    /**
     * 文件上传页面
     */
    @RequestMapping(value = "/fileUpload.gsp", method = RequestMethod.GET)
    public final ModelAndView addPage() {
        ModelAndView mav = new ModelAndView("common/fileUpload");
        mav.addObject("upType", "video");
        return mav;
    }

    /**
     * 根据id获取
     */
    @RequestMapping(value = "/findByIds.gsp", method = RequestMethod.POST)
    @ResponseBody
    public JsonResultBean findByIds(@RequestParam("ids") final String ids) throws BusinessException {
        return new JsonResultBean(videoService.findByIds(ids));
    }

    /**
     * 返回视频列表查询界面
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.GET)
    public ModelAndView listPage() throws BusinessException {
        ModelAndView mav = new ModelAndView(LIST_PAGE);
        return mav;
    }

    /**
     * 分页查询 视频
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.POST)
    @ResponseBody
    public PageGridBean findByPage(final CmsVideoQuery query) throws BusinessException {
        Page<CmsVideo> result = videoService.findByPage(query);
        return new PageGridBean(query, result, true);
    }

    /**
     * 根据id查看 CmsVideo
     */
    @RequestMapping(value = "/show_{id}.gsp", method = RequestMethod.GET)
    public final ModelAndView showPage(@PathVariable("id") final String id) throws BusinessException {
        ModelAndView mav = new ModelAndView(SHOW_PAGE);
        mav.addObject("result", videoService.get(id));
        return mav;
    }

    /**
     * 根据id删除 CmsVideo
     */
    @RequestMapping(value = "/delete_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean deleteById(@PathVariable("id") final String id) throws BusinessException {
        videoService.delete(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 单文件上传
     */
    @RequestMapping(value = "/uploadFile.gsp")
    @ResponseBody
    public void singleFile(final FileUploadBean uploadItem, final CmsVideoForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        CmsVideoForm videoForm = videoService.add(uploadItem, form, request);
        response.setContentType("text/html;charset=UTF-8");
        JsonResultBean result = new JsonResultBean(videoForm.getId());
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
     * 将form表单里面的String Date转换成Date型，字符串去掉空白
     */
    @InitBinder
    protected final void initBinder(final HttpServletRequest request, final ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(ConstantPattern4Date.YYYY_MM_DD), true));
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}