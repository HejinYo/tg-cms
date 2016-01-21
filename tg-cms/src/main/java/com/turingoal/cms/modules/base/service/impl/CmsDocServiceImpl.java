package com.turingoal.cms.modules.base.service.impl;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.modules.base.domain.CmsDoc;
import com.turingoal.cms.modules.base.domain.form.CmsDocForm;
import com.turingoal.cms.modules.base.domain.query.CmsDocQuery;
import com.turingoal.cms.modules.base.repository.CmsDocDao;
import com.turingoal.cms.modules.base.service.CmsDocService;
import com.turingoal.common.annotation.MethodLog;
import com.turingoal.common.bean.FileUploadBean;
import com.turingoal.common.util.io.FileUtil;
import com.turingoal.common.util.lang.StringUtil;

/**
 * 文档Service
 */
@Service
public class CmsDocServiceImpl implements CmsDocService {
    @Autowired
    private CmsDocDao docDao;

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
    public CmsDocForm add(final FileUploadBean uploadItem, final CmsDocForm form, final HttpServletRequest request) throws Exception {
        String md5str = getMd5ByFile(uploadItem.getFile());
        CmsDocForm attachment = docDao.getByMd5(md5str);
        if (attachment != null) {
            System.out.println("文件秒传成功！");
        } else {
            attachment = new CmsDocForm();
            String originalFilename = uploadItem.getFile().getOriginalFilename();
            String suffix = FileUtil.getSuffix(originalFilename);
            String attachPath = LocalDateTime.now().format(DateTimeFormatter.ofPattern("/yyyyMM/yyyyMMdd/")) + attachment.getId();
            // String realPath = uploadpath + attachPath;
            String realPath = request.getServletContext().getRealPath("/uploads") + attachPath;
            // ****上传文件****
            // 上传路径://真实路径/文件上传路径/日期/时间.后缀
            String targetPathNameWithoutSuffix = realPath;
            FileUtil.uploadFileSpringMVC(uploadItem.getFile(), targetPathNameWithoutSuffix);

            attachment.setDocName(originalFilename);
            attachment.setDocLength(Long.valueOf(uploadItem.getFile().getSize()));
            attachment.setDocPath("/uploads" + attachPath + "." + suffix);
            attachment.setFormat(suffix);
            attachment.setPublishTime(new Date());
            attachment.setMd5(md5str);
            if (!StringUtil.isNullOrEmpty(form.getTitle())) {
                attachment.setDocName(form.getTitle());
            }
            if (!StringUtil.isNullOrEmpty(form.getDescription())) {
                attachment.setDescription(form.getDescription());
            }
            // ****保存数据****
            docDao.add(attachment);
        }
        return attachment;
    }

    /**
     * 分页查询 文档
     */
    @MethodLog(name = "分页查询文档", description = "根据条件分页查询文档")
    public Page<CmsDoc> findByPage(final CmsDocQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        return (Page<CmsDoc>) docDao.find(query);
    }

    /**
     * 通过id得到一个 文档
     */
    @MethodLog(name = "通过id得到文档", description = "通过id得到一个文档")
    public CmsDoc get(final String id) {
        CmsDoc doc = docDao.get(id);
        if (doc != null) {
            doc.setDocPath(SystemHelper.getGlobal().getContextPath() + doc.getDocPath());
        }
        return doc;
    }

    /**
     * 新增 文档
     */
    @MethodLog(name = "新增文档", description = "新增一个文档")
    public void add(final CmsDocForm form) {
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        docDao.add(form);
    }

    /**
     * 修改 文档
     */
    @MethodLog(name = "修改文档", description = "修改一个文档")
    public int update(final CmsDocForm form) {
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        return docDao.update(form);
    }

    /**
     * 根据id删除一个 文档
     */
    @MethodLog(name = "删除文档", description = "根据id删除一个文档")
    public int delete(final String id) {
        return docDao.delete(id);
    }

    /**
     * 启用文档
     */
    @MethodLog(name = "启用文档", description = "根据id启用一个文档")
    public int enable(final String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("state", 1);
        return docDao.changeState(params);
    }

    /**
     * 停用文档
     */
    @MethodLog(name = "停用文档", description = "根据id停用一个文档")
    public int disable(final String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("state", 2);
        return docDao.changeState(params);
    }

    /**
     * 获取所有文件的格式
     */
    @MethodLog(name = "获取所有文件的格式", description = "获取所有文件的格式")
    public List<CmsDoc> findFormat() {
        List<CmsDoc> format = docDao.findFormat();
        return format;
    }

    @Override
    public List<CmsDoc> findByIds(final String ids) {
        List<CmsDoc> docs = new ArrayList<CmsDoc>();
        if (!StringUtil.isNullOrEmpty(ids)) {
            String[] str = ids.split(",");
            docs = docDao.findByIds(str);
        }
        for (CmsDoc cmsDoc : docs) {
            if (cmsDoc != null) {
                // cmsImage.setSrc(SystemHelper.getGlobal().getContextPath() + cmsImage.getSrc());
                cmsDoc.setDocPath(SystemHelper.getGlobal().getContextPath() + cmsDoc.getDocPath());
            }
        }
        return docs;
    }
}