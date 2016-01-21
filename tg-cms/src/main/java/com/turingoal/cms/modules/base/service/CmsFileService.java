package com.turingoal.cms.modules.base.service;

import java.io.FileNotFoundException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.base.domain.CmsFile;
import com.turingoal.cms.modules.base.domain.form.CmsFileForm;
import com.turingoal.cms.modules.base.domain.query.CmsFileQuery;
import com.turingoal.common.bean.FileUploadBean;

/**
 * FileService
 */
public interface CmsFileService {

    /**
     * 查询全部 File
     */
    List<CmsFile> findAll(final CmsFileQuery query);

    /**
     * 分页查询 File
     */
    Page<CmsFile> findByPage(final CmsFileQuery query);

    /**
     * 通过id得到一个 File
     */
    CmsFile get(final String id);

    /**
     * 新增 File
     */
    void add(final CmsFileForm form);

    /**
     * 修改 File
     */
    int update(final CmsFileForm form);

    /**
     * 根据id删除一个 File
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
     * 单文件上传
     * 
     * @throws Exception
     */
    CmsFileForm add(FileUploadBean uploadItem, final CmsFileForm form, HttpServletRequest request) throws Exception;

    /**
     * 下载文件
     */
    void downFile(String ids, HttpServletResponse response) throws FileNotFoundException;

    /**
     * 获取所有文件的格式
     */
    List<CmsFile> findFormat();

    /**
     * 根据文件获取
     */
    List<CmsFile> findByIds(String ids);
}