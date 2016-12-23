package com.turingoal.cms.modules.base.web.controller.admin;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.Page;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.modules.base.domain.CmsImage;
import com.turingoal.cms.modules.base.domain.Global;
import com.turingoal.cms.modules.base.domain.form.CmsImageForm;
import com.turingoal.cms.modules.base.domain.query.CmsImageQuery;
import com.turingoal.cms.modules.base.service.CmsImageService;
import com.turingoal.cms.modules.base.service.GlobalService;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.bean.PageGridBean;
import com.turingoal.common.constants.ConstantPattern4Date;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.support.spring.SpringBindingResultWrapper;
import com.turingoal.common.support.validator.ValidGroupUpdate;

/**
 * ImageController
 */
@Controller
@RequestMapping("/m/base/image")
public class CmsImageController {

    private static final String LIST_PAGE = "modules/material/image/list";
    private static final String EDIT_PAGE = "modules/material/image/edit";
    private static final String SHOW_PAGE = "modules/material/image/show";
    @Autowired
    private CmsImageService imageService;
    @Autowired
    private GlobalService globalService;

    /**
     * 图片上传页面
     */
    @RequestMapping(value = "/imageUpload.gsp", method = RequestMethod.GET)
    public final String imageUpload() {
        return "common/imageUpload";
    }

    /**
     * 图片上传页面
     */
    @RequestMapping(value = "/imageUpload2.gsp", method = RequestMethod.GET)
    public final String imageUpload2() {
        if (SystemHelper.getGlobal() == null) {
            Global gs = globalService.get();
            SystemHelper.setGlobal(gs);
        }
        return "common/imageUpload2";
    }

    /**
     * 返回图片查询界面
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.GET)
    public ModelAndView listPage() throws BusinessException {
        ModelAndView mav = new ModelAndView(LIST_PAGE);
        return mav;
    }

    /**
     * 分页查询 图片
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.POST)
    @ResponseBody
    public PageGridBean findByPage(final CmsImageQuery query) throws BusinessException {
        Page<CmsImage> result = imageService.findByPage(query);
        return new PageGridBean(query, result, true);
    }

    /**
     * 根据id查看 CmsVideo
     */
    @RequestMapping(value = "/show_{id}.gsp", method = RequestMethod.GET)
    public final ModelAndView showPage(@PathVariable("id") final String id) throws BusinessException {
        ModelAndView mav = new ModelAndView(SHOW_PAGE);
        mav.addObject("result", imageService.get(id));
        return mav;
    }

    /**
     * 通过ids查询 Image
     */
    @RequestMapping(value = "/findByIds")
    @ResponseBody
    public JsonResultBean findByIds(@RequestParam("ids") final String ids) throws BusinessException {
        return new JsonResultBean(imageService.findByIds(ids));
    }

    /**
     * 新增 Image
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean add(final CmsImageForm form, final BindingResult bindingResult, final HttpServletRequest request, @RequestParam final MultipartFile myfile) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            String realPath = request.getSession().getServletContext().getRealPath("/upload");
            // 这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
            try {
                FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, myfile.getOriginalFilename()));
                imageService.add(form);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 编辑修改
     */
    @RequestMapping(value = "/edit_{id}.gsp", method = RequestMethod.GET)
    public final ModelAndView editPage(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView(EDIT_PAGE);
        mav.addObject("result", imageService.get(id));
        return mav;
    }

    /**
     * 修改 Image
     */
    @RequestMapping(value = "/edit.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean update(@Validated({ ValidGroupUpdate.class }) @ModelAttribute("form") final CmsImageForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            imageService.update(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 根据id删除 Image
     */
    @RequestMapping(value = "/delete_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean deleteById(@PathVariable("id") final String id) throws BusinessException {
        imageService.delete(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id启用 Image
     */
    @RequestMapping(value = "/enable_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean enable(@PathVariable("id") final String id) throws BusinessException {
        imageService.enable(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id停用 Image
     */
    @RequestMapping(value = "/disable_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean disable(@PathVariable("id") final String id) throws BusinessException {
        imageService.disable(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 多图片上传
     */
    @RequestMapping(value = "/uploadImg")
    @ResponseBody
    public Map<String, Object> uploadImg(final CmsImageForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        return imageService.uploadImg(form, request);
    }

    /**
     * 本地上传
     */
    @RequestMapping(value = "/uploadImgLoc")
    @ResponseBody
    public JsonResultBean uploadImgLoc(final CmsImageForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        Map<String, Object> map = imageService.uploadImgLoc(form, request);
        if ((boolean) map.get("isError")) {
            return new JsonResultBean(JsonResultBean.FAULT, (String) map.get("mes"));
        } else {
            return new JsonResultBean(JsonResultBean.SUCCESS, (String) map.get("mes"));
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