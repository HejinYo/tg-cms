package com.turingoal.cms.modules.base.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.base.domain.CmsDoc;
import com.turingoal.cms.modules.base.domain.form.CmsDocForm;
import com.turingoal.cms.modules.base.domain.query.CmsDocQuery;
import com.turingoal.common.bean.FileUploadBean;

/**
 * 文档Service
 */
public interface CmsDocService {

    /**
     * 分页查询 文档
     */
    Page<CmsDoc> findByPage(final CmsDocQuery query);

    /**
     * 通过id得到一个 文档
     */
    CmsDoc get(final String id);

    /**
     * 新增 文档
     */
    void add(final CmsDocForm form);

    /**
     * 修改 文档
     */
    int update(final CmsDocForm form);

    /**
     * 根据id删除一个 文档
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
    CmsDocForm add(FileUploadBean uploadItem, CmsDocForm form, HttpServletRequest request) throws Exception;

    /**
     * 获取所有文件的格式
     */
    List<CmsDoc> findFormat();

    /**
     * 根据ids获取
     */
    List<CmsDoc> findByIds(String ids);
}