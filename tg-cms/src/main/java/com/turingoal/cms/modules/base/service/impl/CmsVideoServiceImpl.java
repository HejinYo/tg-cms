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
import com.turingoal.cms.modules.base.domain.CmsVideo;
import com.turingoal.cms.modules.base.domain.form.CmsVideoForm;
import com.turingoal.cms.modules.base.domain.query.CmsVideoQuery;
import com.turingoal.cms.modules.base.repository.CmsVideoDao;
import com.turingoal.cms.modules.base.service.CmsVideoService;
import com.turingoal.common.annotation.MethodLog;
import com.turingoal.common.bean.FileUploadBean;
import com.turingoal.common.util.io.FileUtil;
import com.turingoal.common.util.lang.StringUtil;

/**
 * 视频Service
 */
@Service
public class CmsVideoServiceImpl implements CmsVideoService {
    @Autowired
    private CmsVideoDao videoDao;

    /**
     * 分页查询 视频
     */
    @MethodLog(name = "分页查询视频", description = "根据条件分页查询视频")
    public Page<CmsVideo> findByPage(final CmsVideoQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        return (Page<CmsVideo>) videoDao.find(query);
    }

    /**
     * 通过id得到一个 视频
     */
    @MethodLog(name = "通过id得到视频", description = "通过id得到一个视频")
    public CmsVideo get(final String id) {
        CmsVideo video = videoDao.get(id);
        if (video != null) {
            video.setVideoPath(SystemHelper.getGlobal().getContextPath() + video.getVideoPath());
        }
        return video;
    }

    /**
     * 新增 视频
     */
    @MethodLog(name = "新增视频", description = "新增一个视频")
    public void add(final CmsVideoForm form) {
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        videoDao.add(form);
    }

    /**
     * 修改 视频
     */
    @MethodLog(name = "修改视频", description = "修改一个视频")
    public int update(final CmsVideoForm form) {
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        return videoDao.update(form);
    }

    /**
     * 根据id删除一个 视频
     */
    @MethodLog(name = "删除视频", description = "根据id删除一个视频")
    public int delete(final String id) {
        return videoDao.delete(id);
    }

    /**
     * 启用
     */
    @MethodLog(name = "启用视频", description = "根据id启用一个视频")
    public int enable(final String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("state", 1);
        return videoDao.changeState(params);
    }

    /**
     * 停用
     */
    @MethodLog(name = "停用视频", description = "根据id停用一个视频")
    public int disable(final String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("state", 2);
        return videoDao.changeState(params);
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

    @Override
    public CmsVideoForm add(final FileUploadBean uploadItem, final CmsVideoForm form, final HttpServletRequest request) throws Exception {
        String md5str = getMd5ByFile(uploadItem.getFile());
        CmsVideoForm attachment = videoDao.getByMd5(md5str);
        if (attachment != null) {
            System.out.println("文件秒传成功！");
        } else {
            attachment = new CmsVideoForm();
            String originalFilename = uploadItem.getFile().getOriginalFilename();
            String suffix = FileUtil.getSuffix(originalFilename);
            String attachPath = LocalDateTime.now().format(DateTimeFormatter.ofPattern("/yyyyMM/yyyyMMdd/")) + attachment.getId();
            // String realPath = uploadpath + attachPath;
            String realPath = request.getServletContext().getRealPath("/uploads") + attachPath;
            // ****上传文件****
            // 上传路径://真实路径/文件上传路径/日期/时间.后缀
            String targetPathNameWithoutSuffix = realPath;
            FileUtil.uploadFileSpringMVC(uploadItem.getFile(), targetPathNameWithoutSuffix);

            attachment.setVideoName(originalFilename);
            attachment.setVideoLength(Long.valueOf(uploadItem.getFile().getSize()));
            attachment.setVideoPath("/uploads" + attachPath + "." + suffix);
            attachment.setFormat(suffix);
            attachment.setPublishTime(new Date());
            attachment.setMd5(md5str);
            if (!StringUtil.isNullOrEmpty(form.getTitle())) {
                attachment.setVideoName(form.getTitle());
            }
            if (!StringUtil.isNullOrEmpty(form.getDescription())) {
                attachment.setDescription(form.getDescription());
            }
            // ****保存数据****
            videoDao.add(attachment);
        }
        return attachment;
    }

    /**
     * 获取所有文件的格式
     */
    @MethodLog(name = "获取所有文件的格式", description = "获取所有文件的格式")
    public List<CmsVideo> findFormat() {
        List<CmsVideo> format = videoDao.findFormat();
        return format;
    }

    @Override
    public List<CmsVideo> findByIds(final String ids) {
        List<CmsVideo> videos = new ArrayList<CmsVideo>();
        if (!StringUtil.isNullOrEmpty(ids)) {
            String[] str = ids.split(",");
            videos = videoDao.findByIds(str);
        }
        for (CmsVideo cmsVideo : videos) {
            if (cmsVideo != null) {
                // cmsImage.setSrc(SystemHelper.getGlobal().getContextPath() + cmsImage.getSrc());
                cmsVideo.setVideoPath(SystemHelper.getGlobal().getContextPath() + cmsVideo.getVideoPath());
            }
        }
        return videos;
    }
}