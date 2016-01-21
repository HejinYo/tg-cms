package com.turingoal.cms.modules.base.service;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.base.domain.CmsImage;
import com.turingoal.cms.modules.base.domain.form.CmsImageForm;
import com.turingoal.cms.modules.base.domain.query.CmsImageQuery;

/**
 * ImageService
 */
public interface CmsImageService {

    /**
     * 分页查询 Image
     */
    Page<CmsImage> findByPage(final CmsImageQuery query);

    /**
     * 通过id得到一个 Image
     */
    CmsImage get(final String id);

    /**
     * 通过ids得到 Image
     */
    List<CmsImage> findByIds(final String ids);

    /**
     * 新增 Image
     */
    void add(final CmsImageForm form);

    /**
     * 修改 Image
     */
    int update(final CmsImageForm form);

    /**
     * 根据id删除一个 Image
     */
    int delete(final String id);

    /**
     * 启用
     */
    int enable(final String id);

    /**
     * 停用
     */
    int disable(final String id);

    /**
     * 多图片上传
     */
    Map<String, Object> uploadImg(final CmsImageForm uploadItem, final HttpServletRequest request) throws Exception;

    /**
     * 本地上传
     */
    Map<String, Object> uploadImgLoc(final CmsImageForm form, final HttpServletRequest request) throws Exception;

    /**
     * 获取所有文件的格式
     */
    List<CmsImage> findFormat();
}