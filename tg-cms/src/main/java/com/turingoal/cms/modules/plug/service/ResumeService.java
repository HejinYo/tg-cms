package com.turingoal.cms.modules.plug.service;

import java.util.List;
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.plug.domain.Resume;
import com.turingoal.cms.modules.plug.domain.form.ResumeForm;
import com.turingoal.cms.modules.plug.domain.query.ResumeQuery;

/**
 * ResumeService
 */
public interface ResumeService {

    /**
     * 查询全部 Resume
     */
    List<Resume> findAll(final ResumeQuery query);

    /**
     * 分页查询 Resume
     */
    Page<Resume> findByPage(final ResumeQuery query);

    /**
     * 通过id得到一个 Resume
     */
    Resume get(final String id);

    /**
     * 新增 Resume
     */
    void add(final ResumeForm form);

    /**
     * 修改 Resume
     */
    int update(final ResumeForm form);

    /**
     * 根据id删除一个 Resume
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
}