package com.turingoal.cms.modules.ext.repository;

import java.util.List;
import com.turingoal.cms.modules.ext.domain.QuestionItem;
import com.turingoal.cms.modules.ext.domain.form.QuestionItemForm;
import com.turingoal.cms.modules.ext.domain.query.QuestionItemQuery;

/**
 * 调查问卷项Dao
 */
public interface QuestionItemDao {

    /**
     * 查询 调查问卷项
     */
    List<QuestionItem> find(final QuestionItemQuery query);

    /**
     * 通过id得到一个 调查问卷项
     */
    QuestionItem get(final String id);

    /**
     * 新增 调查问卷项
     */
    void add(final QuestionItemForm form);

    /**
     * 修改 调查问卷项
     */
    int update(final QuestionItemForm form);

    /**
     * 根据id删除一个 调查问卷项
     */
    int delete(final String id);

    /**
     * 根据问卷id获取问卷调查项
     */
    List<QuestionItem> findByQuestionId(final String questionId);
}