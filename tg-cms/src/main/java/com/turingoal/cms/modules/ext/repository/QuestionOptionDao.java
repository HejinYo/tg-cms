package com.turingoal.cms.modules.ext.repository;

import java.util.List;
import com.turingoal.cms.modules.ext.domain.QuestionOption;
import com.turingoal.cms.modules.ext.domain.form.QuestionOptionForm;
import com.turingoal.cms.modules.ext.domain.query.QuestionOptionQuery;

/**
 * 调查问卷选项Dao
 */
public interface QuestionOptionDao {

    /**
     * 查询 调查问卷选项
     */
    List<QuestionOption> find(final QuestionOptionQuery query);

    /**
     * 通过id得到一个 调查问卷选项
     */
    QuestionOption get(final String id);

    /**
     * 新增 调查问卷选项
     */
    void add(final QuestionOptionForm form);

    /**
     * 修改 调查问卷选项
     */
    int update(final QuestionOptionForm form);

    /**
     * 根据id删除一个 调查问卷选项
     */
    int delete(final String id);

    /**
     * 根据问卷调查项查询选项
     * 
     * @param itemId
     * @return
     */
    List<QuestionOption> findByItemId(final String itemId);
}