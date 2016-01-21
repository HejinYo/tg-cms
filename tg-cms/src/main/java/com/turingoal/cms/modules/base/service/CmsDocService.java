package com.turingoal.cms.modules.base.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.base.domain.CmsDoc;
import com.turingoal.cms.modules.base.domain.form.CmsDocForm;
import com.turingoal.cms.modules.base.domain.query.CmsDocQuery;
import com.turingoal.common.bean.FileUploadBean;

/**
 * CmsDocService
 */
public interface CmsDocService {

    /**
     * 分页查询 CmsDoc
     */
    Page<CmsDoc> findByPage(final CmsDocQuery query);

    /**
     * 通过id得到一个 CmsDoc
     */
    CmsDoc get(final String id);

    /**
     * 新增 CmsDoc
     */
    void add(final CmsDocForm form);

    /**
     * 修改 CmsDoc
     */
    int update(final CmsDocForm form);

    /**
     * 根据id删除一个 CmsDoc
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