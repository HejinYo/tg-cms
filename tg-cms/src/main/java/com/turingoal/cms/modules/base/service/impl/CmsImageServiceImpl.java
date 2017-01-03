package com.turingoal.cms.modules.base.service.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.modules.base.domain.CmsImage;
import com.turingoal.cms.modules.base.domain.form.CmsImageForm;
import com.turingoal.cms.modules.base.domain.query.CmsImageQuery;
import com.turingoal.cms.modules.base.repository.CmsImageDao;
import com.turingoal.cms.modules.base.service.CmsImageService;
import com.turingoal.common.annotation.MethodLog;
import com.turingoal.common.util.io.FileUtil;
import com.turingoal.common.util.lang.StringUtil;
import com.turingoal.common.util.media.ImageUtil;

/**
 * 图片Service
 */
@Service
public class CmsImageServiceImpl implements CmsImageService {
    @Value("${system.baseStoragePath}")
    private String uploadpath;
    @Autowired
    private CmsImageDao imageDao;

    /**
     * 分页查询 Image
     */
    @MethodLog(name = "分页查询图片", description = "根据条件分页查询图片")
    public Page<CmsImage> findByPage(final CmsImageQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        return (Page<CmsImage>) imageDao.find(query);
    }

    /**
     * 通过id得到一个 图片
     */
    @MethodLog(name = "通过id得到图片", description = "通过id得到一个图片")
    public CmsImage get(final String id) {
        CmsImage image = imageDao.get(id);
        if (image != null) {
            image.setImgPath(SystemHelper.getGlobal().getContextPath() + image.getImgPath());
        }
        return image;
    }

    /**
     * 通过ids得到 图片
     */
    @MethodLog(name = "通过ids得到图片", description = "通过ids得到一个图片")
    public List<CmsImage> findByIds(final String ids) {
        List<CmsImage> imags = new ArrayList<CmsImage>();
        if (!StringUtil.isNullOrEmpty(ids)) {
            String[] str = ids.split(",");
            imags = imageDao.findByIds(str);
        }
        for (CmsImage cmsImage : imags) {
            if (cmsImage != null) {
                cmsImage.setImgPath(SystemHelper.getGlobal().getContextPath() + cmsImage.getImgPath());
            }
        }
        return imags;
    }

    /**
     * 新增 Image
     */
    @MethodLog(name = "新增图片", description = "新增一个图片")
    public void add(final CmsImageForm form) {
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        imageDao.add(form);
    }

    /**
     * 修改 图片
     */
    @MethodLog(name = "修改图片", description = "修改一个图片")
    public int update(final CmsImageForm form) {
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        return imageDao.update(form);
    }

    /**
     * 根据id删除一个 图片
     */
    @MethodLog(name = "删除图片", description = "根据id删除一个图片")
    public int delete(final String id) {
        return imageDao.delete(id);
    }

    /**
     * 启用
     */
    @MethodLog(name = "启用图片", description = "根据id启用一个图片")
    public int enable(final String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("state", 1);
        return imageDao.changeState(params);
    }

    /**
     * 停用
     */
    @MethodLog(name = "停用图片", description = "根据id停用一个图片")
    public int disable(final String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("state", 2);
        return imageDao.changeState(params);
    }

    /**
     * 上传图片,返回图片id
     */
    @MethodLog(name = "上传图片", description = "上传图片")
    public Map<String, Object> uploadImg(final CmsImageForm uploadItem, final HttpServletRequest request) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", false);
        String originalFilename = uploadItem.getFile().getOriginalFilename();
        String suffix = FileUtil.getSuffix(originalFilename).toLowerCase();
        List<String> suffixs = Arrays.asList("gif", "jpg", "jpeg", "bmp", "png");
        if (!suffixs.contains(suffix)) {
            result.put("msg", "图片格式不是gif,jpg,jpeg,bmp,png文件，请重新上传！！！");
            return result;
        }
        String md5 = getMd5ByFile(uploadItem.getFile());

        List<CmsImageForm> forms = imageDao.getByMd5(md5);
        CmsImageForm form = (forms != null && forms.size() > 0) ? forms.get(0) : null;
        if (form != null) {
            System.out.println("文件秒传成功！");
        } else {
            // CmsImageForm form = new CmsImageForm();
            form = new CmsImageForm();
            String attachPath = LocalDateTime.now().format(DateTimeFormatter.ofPattern("/yyyyMM/yyyyMMdd/")) + form.getId();
            String realPath = request.getServletContext().getRealPath("/uploads/image") + attachPath;
            FileUtil.uploadFileSpringMVC(uploadItem.getFile(), realPath);

            ImageUtil.doThumb(realPath + "." + suffix, realPath + "." + suffix + "_200x200." + suffix, 200, 200); // 图片压缩

            String path = "/uploads/image" + attachPath + "." + suffix;
            form.setImgName(originalFilename);
            form.setImgLength(uploadItem.getFile().getSize());
            form.setFormat(suffix);
            form.setMd5(md5);
            form.setPublishTime(new Date());
            form.setImgPath(path);
            if (!StringUtil.isNullOrEmpty(uploadItem.getTitle())) {
                form.setImgName(uploadItem.getTitle());
            }
            if (!StringUtil.isNullOrEmpty(uploadItem.getDescription())) {
                form.setDescription(uploadItem.getDescription());
            }
            this.add(form);
        }
        result.put("success", true);
        result.put("obj", form.getId());
        result.put("path", SystemHelper.getGlobal().getContextPath() + form.getImgPath());
        return result;
    }

    /**
     * 上传图片，返回图片路径
     */
    @MethodLog(name = "上传图片", description = "上传图片")
    public Map<String, Object> uploadImgLoc(final CmsImageForm form, final HttpServletRequest request) throws Exception {
        String originalFilename = form.getFile().getOriginalFilename();
        String md5 = getMd5ByFile(form.getFile());
        String suffix = FileUtil.getSuffix(originalFilename);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", false);
        List<String> suffixs = Arrays.asList("gif", "jpg", "jpeg", "bmp", "png");
        if (!suffixs.contains(suffix)) {
            map.put("msg", "图片格式不是gif,jpg,jpeg,bmp,png文件，请重新上传！！！");
            return map;
        }
        /*
         * if (String.valueOf(form.getFile().getSize()).length() > 6) { // return new JsonResultBean(JsonResultBean.FAULT, "图片大小不能大于999KB，请重新上传！！！"); map.put("isError", true); map.put("mes", "图片大小不能大于999KB，请重新上传！！！"); return map; }
         */
        Random random = new Random();
        int i = random.nextInt(100);
        String attachPath = LocalDateTime.now().format(DateTimeFormatter.ofPattern("/yyyyMMdd/HHmmss")) + i;
        // String realPath = uploadpath + "/image/" + attachPath;
        String realPath = request.getServletContext().getRealPath("/uploads/image") + attachPath;
        // ****上传文件****
        // 上传路径://真实路径/文件上传路径/日期/时间.后缀
        String targetPathNameWithoutSuffix = realPath;
        FileUtil.uploadFileSpringMVC(form.getFile(), targetPathNameWithoutSuffix);
        String path = "/uploads/image" + attachPath + "." + suffix;
        form.setImgName(originalFilename);
        form.setImgLength(form.getFile().getSize());
        form.setFormat(suffix);
        form.setMd5(md5);
        form.setPublishTime(new Date());
        form.setImgPath(path);
        this.add(form);
        map.put("isError", false);
        map.put("mes", path);
        return map;
    }

    /**
     * 生成文件MD5值
     */
    public static String getMd5ByFile(final CommonsMultipartFile file) throws NoSuchAlgorithmException {
        byte[] uploadBytes = file.getBytes();
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] digest = md5.digest(uploadBytes);
        String hashString = new BigInteger(1, digest).toString(16);
        return hashString.toUpperCase();
    }

    /**
     * 获取所有文件的格式
     */
    @MethodLog(name = "获取所有文件的格式", description = "获取所有文件的格式")
    public List<CmsImage> findFormat() {
        List<CmsImage> format = imageDao.findFormat();
        return format;
    }
}