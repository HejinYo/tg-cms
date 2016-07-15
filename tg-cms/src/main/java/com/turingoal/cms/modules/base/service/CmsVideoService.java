package com.turingoal.cms.modules.base.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.base.domain.CmsVideo;
import com.turingoal.cms.modules.base.domain.form.CmsVideoForm;
import com.turingoal.cms.modules.base.domain.query.CmsVideoQuery;
import com.turingoal.common.bean.FileUploadBean;

/**
 * 视频Service
 */
public interface CmsVideoService {

    /**
     * 分页查询 视频
     */
    Page<CmsVideo> findByPage(final CmsVideoQuery query);

    /**
     * 通过id得到一个 视频
     */
    CmsVideo get(final String id);

    /**
     * 新增 视频
     */
    void add(final CmsVideoForm form);

    /**
     * 修改 视频
     */
    int update(final CmsVideoForm form);

    /**
     * 根据id删除一个 视频
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
     * 新增文件
     */
    CmsVideoForm add(FileUploadBean uploadItem, CmsVideoForm form, HttpServletRequest request) throws Exception;

    /**
     * 获取所有文件的格式
     */
    List<CmsVideo> findFormat();

    /**
     * 根据文件获取
     */
    List<CmsVideo> findByIds(String ids);
}