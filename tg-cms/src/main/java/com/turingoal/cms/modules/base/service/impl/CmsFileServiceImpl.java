package com.turingoal.cms.modules.base.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.modules.base.domain.CmsFile;
import com.turingoal.cms.modules.base.domain.form.CmsFileForm;
import com.turingoal.cms.modules.base.domain.query.CmsFileQuery;
import com.turingoal.cms.modules.base.repository.CmsFileDao;
import com.turingoal.cms.modules.base.service.CmsFileService;
import com.turingoal.common.annotation.MethodLog;
import com.turingoal.common.bean.FileUploadBean;
import com.turingoal.common.util.io.FileUtil;
import com.turingoal.common.util.lang.StringUtil;

/**
 * 文件Service
 */
@Service
public class CmsFileServiceImpl implements CmsFileService {
    @Autowired
    private CmsFileDao fileDao;

    @Value("${system.baseStoragePath}")
    private String uploadpath;

    /**
     * 查询全部 File
     */
    @MethodLog(name = "查询全部文件", description = "根据条件查询全部的文件")
    public List<CmsFile> findAll(final CmsFileQuery query) {
        List<CmsFile> fileList = new ArrayList<CmsFile>();
        if (!StringUtil.isNullOrEmpty(query.getIds())) {
            query.setIdStrs(query.getIds().split(","));
            fileList = fileDao.find(query);
        }
        return fileList;
    }

    /**
     * 分页查询文件
     */
    @MethodLog(name = "分页查询文件", description = "根据条件分页查询文件")
    public Page<CmsFile> findByPage(final CmsFileQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        return (Page<CmsFile>) fileDao.find(query);
    }

    /**
     * 通过id得到一个 文件
     */
    @MethodLog(name = "通过id得到文件", description = "通过id得到一个文件")
    public CmsFile get(final String id) {
        CmsFile file = fileDao.get(id);
        if (file != null) {
            file.setFilePath(SystemHelper.getGlobal().getContextPath() + file.getFilePath());
        }
        return file;
    }

    /**
     * 新增 文件
     */
    @MethodLog(name = "新增文件", description = "新增一个文件")
    public void add(final CmsFileForm form) {
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        fileDao.add(form);
    }

    /**
     * 修改 文件
     */
    @MethodLog(name = "修改文件", description = "修改一个文件")
    public int update(final CmsFileForm form) {
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        return fileDao.update(form);
    }

    /**
     * 根据id删除一个 文件
     */
    @MethodLog(name = "删除文件", description = "根据id删除一个文件")
    public int delete(final String id) {
        return fileDao.delete(id);
    }

    /**
     * 启用
     */
    @MethodLog(name = "启用文件", description = "根据id启用一个文件")
    public int enable(final String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("state", 1);
        return fileDao.changeState(params);
    }

    /**
     * 停用
     */
    @MethodLog(name = "停用文件", description = "根据id停用一个文件")
    public int disable(final String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("state", 2);
        return fileDao.changeState(params);
    }

    /**
     * 获取计算md5值
     */
    public static String getMd5ByFile(final MultipartFile uploadItem) throws NoSuchAlgorithmException, IOException {
        byte[] uploadBytes = uploadItem.getBytes();
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] digest = md5.digest(uploadBytes);
        String hashString = new BigInteger(1, digest).toString(16);
        return hashString.toUpperCase();
    }

    /**
     * 单文件上传
     */
    public CmsFileForm add(final FileUploadBean uploadItem, final CmsFileForm form, final HttpServletRequest request) throws Exception {
        String md5str = getMd5ByFile(uploadItem.getFile());
        CmsFileForm attachment = fileDao.getByMd5(md5str);
        if (attachment != null) {
            System.out.println("文件秒传成功！");
        } else {
            attachment = new CmsFileForm();
            String originalFilename = uploadItem.getFile().getOriginalFilename();
            String suffix = FileUtil.getSuffix(originalFilename);
            String attachPath = LocalDateTime.now().format(DateTimeFormatter.ofPattern("/yyyyMM/yyyyMMdd/")) + attachment.getId();
            // String realPath = uploadpath + attachPath;
            String realPath = request.getServletContext().getRealPath("/uploads") + attachPath;
            // ****上传文件****
            // 上传路径://真实路径/文件上传路径/日期/时间.后缀
            String targetPathNameWithoutSuffix = realPath;
            FileUtil.uploadFileSpringMVC(uploadItem.getFile(), targetPathNameWithoutSuffix);

            attachment.setFileName(originalFilename);
            attachment.setFileLength(Long.valueOf(uploadItem.getFile().getSize()));
            attachment.setFilePath("/uploads" + attachPath + "." + suffix);
            attachment.setFormat(suffix);
            attachment.setPublishTime(new Date());
            attachment.setMd5(md5str);
            if (!StringUtil.isNullOrEmpty(form.getTitle())) {
                attachment.setFileName(form.getTitle());
            }
            if (!StringUtil.isNullOrEmpty(form.getDescription())) {
                attachment.setDescription(form.getDescription());
            }
            // ****保存数据****
            fileDao.add(attachment);
        }
        return attachment;
    }

    /**
     * 文件下载
     */
    @Override
    public void downFile(final String ids, final HttpServletResponse response) throws FileNotFoundException {
        if (!StringUtil.isNullOrEmpty(ids)) {
            for (String strId : ids.split(",")) {
                CmsFile file = get(strId);
                FileUtil.download(uploadpath + "/" + file.getFilePath(), file.getFileName().substring(0, file.getFileName().lastIndexOf(".")), response);
                return;
            }
        }
    }

    /**
     * 获取所有文件的格式
     */
    @MethodLog(name = "获取所有文件的格式", description = "获取所有文件的格式")
    public List<CmsFile> findFormat() {
        List<CmsFile> format = fileDao.findFormat();
        return format;
    }

    @Override
    public List<CmsFile> findByIds(final String ids) {
        List<CmsFile> files = new ArrayList<CmsFile>();
        if (!StringUtil.isNullOrEmpty(ids)) {
            String[] str = ids.split(",");
            files = fileDao.findByIds(str);
        }
        for (CmsFile cmsFile : files) {
            if (cmsFile != null) {
                // cmsImage.setSrc(SystemHelper.getGlobal().getContextPath() + cmsImage.getSrc());
                cmsFile.setFilePath(SystemHelper.getGlobal().getContextPath() + cmsFile.getFilePath());
            }
        }
        return files;
    }
}