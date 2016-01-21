package com.turingoal.cms.modules.plug.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.modules.commons.ConstantAuditState;
import com.turingoal.cms.modules.plug.domain.Resume;
import com.turingoal.cms.modules.plug.domain.form.ResumeForm;
import com.turingoal.cms.modules.plug.domain.query.ResumeQuery;
import com.turingoal.cms.modules.plug.repository.ResumeDao;
import com.turingoal.cms.modules.plug.service.ResumeService;
import com.turingoal.common.annotation.MethodLog;

/**
 * ResumeService
 */
@Service
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    private ResumeDao resumeDao;

    /**
     * 查询全部 Resume
     */
    @MethodLog(name = "查询全部Resume", description = "根据条件查询全部的Resume，不分页")
    public List<Resume> findAll(final ResumeQuery query) {
        return resumeDao.find(query);
    }

    /**
     * 分页查询 Resume
     */
    @MethodLog(name = "分页查询Resume", description = "根据条件分页查询Resume")
    public Page<Resume> findByPage(final ResumeQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        return (Page<Resume>) resumeDao.find(query);
    }

    /**
     * 通过id得到一个 Resume
     */
    @MethodLog(name = "通过id得到Resume", description = "通过id得到一个Resume")
    public Resume get(final String id) {
        return resumeDao.get(id);
    }

    /**
     * 新增 Resume
     */
    @MethodLog(name = "新增Resume", description = "新增一个Resume，返回id")
    public void add(final ResumeForm form) {
        form.setState(ConstantAuditState.AUDIT_PENDING);
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        resumeDao.add(form);
    }

    /**
     * 修改 Resume
     */
    @MethodLog(name = "修改Resume", description = "修改一个Resume")
    public int update(final ResumeForm form) {
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        return resumeDao.update(form);
    }

    /**
     * 根据id删除一个 Resume
     */
    @MethodLog(name = "删除Resume", description = "根据id删除一个Resume")
    public int delete(final String id) {
        return resumeDao.delete(id);
    }

    /**
     * 启用
     */
    @MethodLog(name = "启用Resume", description = "根据id启用一个Resume")
    public int enable(final String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("state", 1);
        return resumeDao.changeState(params);
    }

    /**
     * 停用
     */
    @MethodLog(name = "停用Resume", description = "根据id停用一个Resume")
    public int disable(final String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("state", 2);
        return resumeDao.changeState(params);
    }
}