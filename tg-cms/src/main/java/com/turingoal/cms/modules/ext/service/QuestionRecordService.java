package com.turingoal.cms.modules.ext.service;

import java.util.List;
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.ext.domain.QuestionRecord;
import com.turingoal.cms.modules.ext.domain.form.QuestionRecordForm;
import com.turingoal.cms.modules.ext.domain.query.QuestionRecordQuery;

/**
 * 问卷调查记录Service
 */
public interface QuestionRecordService {

    /**
     * 查询全部 问卷调查记录
     */
    List<QuestionRecord> findAll(final QuestionRecordQuery query);

    /**
     * 分页查询 问卷调查记录
     */
    Page<QuestionRecord> findByPage(final QuestionRecordQuery query);

    /**
     * 通过id得到一个 问卷调查记录
     */
    QuestionRecord get(final String id);

    /**
     * 新增 问卷调查记录
     */
    void add(final QuestionRecordForm form);

    /**
     * 修改 问卷调查记录
     */
    int update(final QuestionRecordForm form);

    /**
     * 根据id删除一个 问卷调查记录
     */
    int delete(final String id);
}