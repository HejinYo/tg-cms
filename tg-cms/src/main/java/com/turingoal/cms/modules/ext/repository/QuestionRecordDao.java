package com.turingoal.cms.modules.ext.repository;

import java.util.List;
import com.turingoal.cms.modules.ext.domain.QuestionRecord;
import com.turingoal.cms.modules.ext.domain.form.QuestionRecordForm;
import com.turingoal.cms.modules.ext.domain.query.QuestionRecordQuery;

/**
 * 问卷调查记录Dao
 */
public interface QuestionRecordDao {

    /**
     * 查询 问卷调查记录
     */
    List<QuestionRecord> find(final QuestionRecordQuery query);

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