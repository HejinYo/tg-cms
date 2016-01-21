package com.turingoal.cms.modules.ext.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.modules.ext.domain.QuestionRecord;
import com.turingoal.cms.modules.ext.domain.form.QuestionRecordForm;
import com.turingoal.cms.modules.ext.domain.query.QuestionRecordQuery;
import com.turingoal.cms.modules.ext.repository.QuestionRecordDao;
import com.turingoal.cms.modules.ext.service.QuestionRecordService;
import com.turingoal.common.annotation.MethodLog;

/**
 * 问卷调查记录Service
 */
@Service
public class QuestionRecordServiceImpl implements QuestionRecordService {
    @Autowired
    private QuestionRecordDao questionRecordDao;

    /**
     * 查询全部 问卷调查记录
     */
    @MethodLog(name = "查询全部问卷调查记录", description = "根据条件查询全部的问卷调查记录，不分页")
    public List<QuestionRecord> findAll(final QuestionRecordQuery query) {
        return questionRecordDao.find(query);
    }

    /**
     * 分页查询 问卷调查记录
     */
    @MethodLog(name = "分页查询问卷调查记录", description = "根据条件分页查询问卷调查记录")
    public Page<QuestionRecord> findByPage(final QuestionRecordQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        return (Page<QuestionRecord>) questionRecordDao.find(query);
    }

    /**
     * 通过id得到一个 问卷调查记录
     */
    @MethodLog(name = "通过id得到问卷调查记录", description = "通过id得到一个问卷调查记录")
    public QuestionRecord get(final String id) {
        return questionRecordDao.get(id);
    }

    /**
     * 新增 问卷调查记录
     */
    @MethodLog(name = "新增问卷调查记录", description = "新增一个问卷调查记录，返回id")
    public void add(final QuestionRecordForm form) {
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        questionRecordDao.add(form);
    }

    /**
     * 修改 问卷调查记录
     */
    @MethodLog(name = "修改问卷调查记录", description = "修改一个问卷调查记录")
    public int update(final QuestionRecordForm form) {
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        return questionRecordDao.update(form);
    }

    /**
     * 根据id删除一个 问卷调查记录
     */
    @MethodLog(name = "删除问卷调查记录", description = "根据id删除一个问卷调查记录")
    public int delete(final String id) {
        return questionRecordDao.delete(id);
    }
}