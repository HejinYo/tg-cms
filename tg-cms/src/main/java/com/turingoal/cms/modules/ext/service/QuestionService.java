package com.turingoal.cms.modules.ext.service;

import java.util.List;
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.ext.domain.Question;
import com.turingoal.cms.modules.ext.domain.QuestionItem;
import com.turingoal.cms.modules.ext.domain.QuestionOption;
import com.turingoal.cms.modules.ext.domain.form.QuestionForm;
import com.turingoal.cms.modules.ext.domain.form.QuestionItemForm;
import com.turingoal.cms.modules.ext.domain.form.QuestionOptionForm;
import com.turingoal.cms.modules.ext.domain.query.QuestionQuery;

/**
 * 调查问卷Service
 */
public interface QuestionService {

    /**
     * 查询全部 调查问卷
     */
    List<Question> findAll(final QuestionQuery query);

    /**
     * 分页查询 调查问卷
     */
    Page<Question> findByPage(final QuestionQuery query);

    /**
     * 通过id得到一个 调查问卷
     */
    Question get(final String id);

    /**
     * 新增 调查问卷
     */
    void add(final QuestionForm form);

    /**
     * 新增 选项信息
     */
    void add(final QuestionItemForm form);

    /**
     * 新增 选项内容
     */
    void add(final QuestionOptionForm form);

    /**
     * 修改 调查问卷
     */
    int update(final QuestionForm form);

    /**
     * 修改 选项信息
     */
    int update(final QuestionItemForm form);

    /**
     * 修改 选项内容
     */
    int update(final QuestionOptionForm form);

    /**
     * 根据id删除一个 调查问卷
     */
    int delete(final String id);

    /**
     * 根据id删除一个 选项信息
     */
    int deleteItem(final String id);

    /**
     * 根据id删除一个 选项内容
     */
    int deleteOption(final String id);

    /**
     * 启用
     */
    int enable(final String id);

    /**
     * 停用
     */
    int disable(final String id);

    /**
     * 根据问卷编码获取问卷
     * 
     * @param query
     * @return
     */
    Question findByCodeNum(QuestionQuery query);

    /**
     * 根据问卷id获取问卷选项
     */
    List<QuestionItem> findItem(final String questionId);

    /**
     * 根据选项id获取对应选项内容
     */
    List<QuestionOption> findOption(final String itemId);

    /**
     * 根据id得到选项信息
     */
    QuestionItem getItem(final String id);

    /**
     * 根据id得到选项内容信息
     */
    QuestionOption getOption(final String id);
}