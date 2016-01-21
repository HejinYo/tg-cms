package com.turingoal.cms.modules.ext.repository;

import java.util.List;
import java.util.Map;
import com.turingoal.cms.modules.ext.domain.Question;
import com.turingoal.cms.modules.ext.domain.form.QuestionForm;
import com.turingoal.cms.modules.ext.domain.query.QuestionQuery;

/**
 * 调查问卷Dao
 */
public interface QuestionDao {

    /**
     * 查询 调查问卷
     */
    List<Question> find(final QuestionQuery query);

    /**
     * 通过id得到一个 调查问卷
     */
    Question get(final String id);

    /**
     * 新增 调查问卷
     */
    void add(final QuestionForm form);

    /**
     * 修改 调查问卷
     */
    int update(final QuestionForm form);

    /**
     * 根据id删除一个 调查问卷
     */
    int delete(final String id);

    /**
     * 修改调查问卷状态
     */
    int changeState(final Map<String, Object> map);

    /**
     * 根据问卷编码获取问卷
     */
    Question findByCodeNum(QuestionQuery query);
}