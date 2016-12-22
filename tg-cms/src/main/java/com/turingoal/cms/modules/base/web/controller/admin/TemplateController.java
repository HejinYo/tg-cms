package com.turingoal.cms.modules.base.web.controller.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.turingoal.cms.modules.base.domain.CmsFile;
import com.turingoal.cms.modules.base.domain.Template;
import com.turingoal.cms.modules.base.domain.form.TemplateForm;
import com.turingoal.cms.modules.base.domain.query.TemplateQuery;
import com.turingoal.cms.modules.base.service.TemplateService;
import com.turingoal.common.bean.BaseTreeNodeBean;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.bean.PageGridBean;
import com.turingoal.common.constants.ConstantPattern4Date;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.util.io.FileUtil;
import com.turingoal.common.support.validator.ValidGroupAdd;
import com.turingoal.common.support.validator.ValidGroupUpdate;

/**
 * 模板Controller
 */
@Controller
@RequestMapping("/m/base/template")
public class TemplateController {
    private static final String LIST_PAGE = "modules/config/template/list";
    private static final String ADD_PAGE = "modules/config/template/add";
    private static final String EDIT_PAGE = "modules/config/template/edit";
    private static final String TEMPLATE_TAB_PAGE = "modules/config/template/templateTab";
    private static final String EDIT_FILE_PAGE = "modules/config/template/editFile";
    private static final String SELECT_TEMPLATE_PAGE = "modules/config/template/selectTemplate";

    @Autowired
    private TemplateService templateService;

    /**
     * 模板列表页面
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.GET)
    public final ModelAndView listPage(final TemplateQuery query) throws BusinessException {
        ModelAndView mav = new ModelAndView(LIST_PAGE);
        List<Template> result = templateService.findAll(query);
        mav.addObject("templateList", result);
        return mav;
    }

    /**
     * 查询全部 模板
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final PageGridBean findAll(final TemplateQuery query) throws BusinessException {
        List<Template> result = templateService.findAll(query);
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
     * 新增 模板
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.POST)
    public final String add(@Validated({ ValidGroupAdd.class }) @ModelAttribute("form") final TemplateForm form, final BindingResult bindingResult, final HttpServletRequest request) throws BusinessException, IOException {
        /*
         * // 数据校验 if (bindingResult.hasErrors()) { String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult); return new JsonResultBean(JsonResultBean.FAULT, errorMsg); } else { form.setContentPath(request.getServletContext().getRealPath("/")); templateService.add(form); return new
         * JsonResultBean(JsonResultBean.SUCCESS); }
         */
        form.setContentPath(request.getServletContext().getRealPath("/"));
        templateService.add(form);
        return "redirect:/admin/m/base/template/list.gsp";
    }

    /**
     * 修改页面
     */
    @RequestMapping(value = "/edit_{id}.gsp", method = RequestMethod.GET)
    public final ModelAndView editPage(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView(EDIT_PAGE);
        mav.addObject("result", templateService.get(id));
        return mav;
    }

    /**
     * 修改 模板
     */
    @RequestMapping(value = "/edit.gsp", method = RequestMethod.POST)
    public final String update(@Validated({ ValidGroupUpdate.class }) @ModelAttribute("form") final TemplateForm form, final BindingResult bindingResult) throws BusinessException {
        /*
         * // 数据校验 if (bindingResult.hasErrors()) { String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult); return new JsonResultBean(JsonResultBean.FAULT, errorMsg); } else { templateService.update(form); return new JsonResultBean(JsonResultBean.SUCCESS); }
         */
        templateService.update(form);
        return "redirect:/admin/m/base/template/list.gsp";
    }

    /**
     * 根据id删除 模板
     */
    @RequestMapping(value = "/delete_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean delete(@PathVariable("id") final String id) throws BusinessException {
        templateService.delete(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 修改页面
     */
    @RequestMapping(value = "/templateTab_{id}.gsp", method = RequestMethod.GET)
    public final ModelAndView templateEdit(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView(TEMPLATE_TAB_PAGE);
        mav.addObject("result", templateService.get(id));
        return mav;
    }

    /**
     * 选择模板页面
     */
    @RequestMapping(value = "/selectTemplate_{fileName}.gsp", method = RequestMethod.GET)
    public final ModelAndView selectTemplatePage(@PathVariable("fileName") final String fileName) {
        ModelAndView mav = new ModelAndView(SELECT_TEMPLATE_PAGE);
        mav.addObject("fileName", fileName);
        return mav;
    }

    /**
     * 刷新文件列表
     */
    public static void refreshFileList(final String strPath, final CmsFile parentFile, final String rootPath, final boolean flag) {
        File dir = new File(strPath);
        File[] files = dir.listFiles();
        if (files == null) {
            return;
        }
        for (int i = 0; i < files.length; i++) {
            File currentFile = files[i];
            CmsFile dirFile = new CmsFile();
            dirFile.setFilePath(currentFile.getAbsolutePath().replace(rootPath, ""));
            dirFile.setLeaf(!currentFile.isDirectory());
            dirFile.setText(currentFile.getName());

            if (parentFile.getNodes() == null) {
                parentFile.setNodes(new ArrayList<BaseTreeNodeBean>());
            }
            if (currentFile.isDirectory()) {
                parentFile.getNodes().add(dirFile);
                refreshFileList(files[i].getAbsolutePath(), dirFile, rootPath, flag);
            } else if (flag) {
                if ("html".equalsIgnoreCase(FileUtil.getSuffix(currentFile.getName()))) {
                    dirFile.setFilePath(dirFile.getFilePath().replace(".html", ""));
                    parentFile.getNodes().add(dirFile);
                }
            }
        }
    }

    /**
     * 获取模板文件
     */
    public static List<CmsFile> getFileListByPath(final String strPath, final String rootPath, final boolean flag) {
        List<CmsFile> fileList = new ArrayList<CmsFile>();
        File dir = new File(strPath);
        File[] files = dir.listFiles();
        if (files != null && files.length > 0) {
            for (int i = 0; i < files.length; i++) {
                File currentFile = files[i];
                CmsFile file = new CmsFile();
                file.setFilePath(currentFile.getAbsolutePath().replace(rootPath, ""));
                file.setLeaf(!currentFile.isDirectory());
                file.setFormat(FileUtil.getSuffix(currentFile.getName()));
                file.setFileName(currentFile.getName());
                file.setFileLength(FileUtil.genFileSize(currentFile.getAbsolutePath()));
                if (!flag) {
                    fileList.add(file);
                } else if (!currentFile.isDirectory()) {
                    if ("html".equalsIgnoreCase(file.getFormat())) {
                        file.setFilePath(file.getFilePath().replace(".html", "").replace("\\", "/"));
                        fileList.add(file);
                    }
                }
            }
        }
        return fileList;
    }

    /**
     * 查询全部模板文件
     */
    @RequestMapping(value = "/getFileTree.gsp")
    @ResponseBody
    public JsonResultBean getOrgTreeGird(final String codeNum, final HttpServletRequest request) throws BusinessException {
        CmsFile rootFile = new CmsFile();
        String path = request.getServletContext().getRealPath("/template/" + (codeNum == null ? "" : codeNum));
        String rootPath = request.getServletContext().getRealPath("/template/");
        rootFile.setFilePath(codeNum);
        rootFile.setText(codeNum);
        refreshFileList(path, rootFile, rootPath, false);

        CmsFile root = new CmsFile();
        root.setNodes(new ArrayList<BaseTreeNodeBean>());
        root.getNodes().add(rootFile);
        return new JsonResultBean(root);
    }

    /**
     * 查询全部模板文件
     */
    @RequestMapping(value = "/getTemplatesByPath.gsp")
    @ResponseBody
    public final PageGridBean getTemplateTree(final String parentPath, final HttpServletRequest request) throws BusinessException {
        String rootPath = request.getServletContext().getRealPath("/template/");
        String path = request.getServletContext().getRealPath("/template/" + (parentPath == null ? "" : parentPath));
        List<CmsFile> result = getFileListByPath(path, rootPath, true);
        return new PageGridBean(result);
    }

    /**
     * 根据目录查询下面的所有文件
     */
    @RequestMapping(value = "/getFilesByPath.gsp")
    @ResponseBody
    public PageGridBean getFilesByPath(final String parentPath, final HttpServletRequest request) throws BusinessException {
        String path = request.getServletContext().getRealPath("/template/" + parentPath);
        String rootPath = request.getServletContext().getRealPath("/template/");
        List<CmsFile> result = getFileListByPath(path, rootPath, false);
        return new PageGridBean(result);
    }

    /**
     * 创建一个新的文件夹
     */
    @RequestMapping(value = "/createFolder")
    @ResponseBody
    public JsonResultBean createFolder(final String codeNum, final String apath, final HttpServletRequest request) throws BusinessException, IOException {
        String path = request.getServletContext().getRealPath("/template/" + (codeNum == null ? "" : codeNum) + "/" + (apath == null ? "" : apath));
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new JsonResultBean();
    }

    /**
     * 创建一个新的文件
     */
    @RequestMapping(value = "/createFile.gsp")
    @ResponseBody
    public JsonResultBean createFile(final String filePath, final String fileName, final String content, final HttpServletRequest request) throws BusinessException, IOException {
        String path = request.getServletContext().getRealPath("/template/" + filePath);
        File file = new File(path);
        jodd.io.FileUtil.writeString(file, content);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 删除文件
     */
    @RequestMapping(value = "/deleteFile.gsp")
    @ResponseBody
    public JsonResultBean deleteFile(final String filePath, final HttpServletRequest request) throws BusinessException, IOException {
        String path = request.getServletContext().getRealPath("/template/" + filePath);
        File file = new File(path);
        String[] childrenFiles = file.list();
        if (file.isFile() && file.exists()) {
            FileUtil.delete(file);
        } else if (childrenFiles != null && childrenFiles.length == 0) {
            FileUtil.delete(file);
        } else {
            return new JsonResultBean(JsonResultBean.FAULT, "请先删除子文件！");
        }
        return new JsonResultBean();
    }

    /**
     * 修改文件名字
     */
    @RequestMapping(value = "/renameFile")
    @ResponseBody
    public final JsonResultBean renameFile(final String codeNum, final String fileName, final String oldPath, final HttpServletRequest request) throws BusinessException, IOException {
        String path = request.getServletContext().getRealPath("/template/" + (codeNum == null ? "" : codeNum) + "/" + (oldPath == null ? "" : oldPath));
        FileUtil.renameFile(path, fileName);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 获取要编辑的文件
     */
    @RequestMapping(value = "/editFile.gsp")
    public final ModelAndView getEditFile(final String filePath, final HttpServletRequest request) throws BusinessException, IOException {
        ModelAndView mav = new ModelAndView(EDIT_FILE_PAGE);
        File file = new File(request.getServletContext().getRealPath("/template/" + filePath));
        Map<String, String> result = new HashMap<String, String>();
        InputStream is = new FileInputStream(file);
        result.put("fileName", file.getName());
        result.put("filePath", filePath);
        result.put("content", IOUtils.toString(is, "UTF-8"));
        mav.addObject("result", result);
        return mav;
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