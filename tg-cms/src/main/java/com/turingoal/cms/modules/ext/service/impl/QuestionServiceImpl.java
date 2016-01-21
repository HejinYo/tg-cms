package com.turingoal.cms.modules.ext.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.modules.ext.domain.Question;
import com.turingoal.cms.modules.ext.domain.QuestionItem;
import com.turingoal.cms.modules.ext.domain.QuestionOption;
import com.turingoal.cms.modules.ext.domain.form.QuestionForm;
import com.turingoal.cms.modules.ext.domain.form.QuestionItemForm;
import com.turingoal.cms.modules.ext.domain.form.QuestionOptionForm;
import com.turingoal.cms.modules.ext.domain.query.QuestionQuery;
import com.turingoal.cms.modules.ext.repository.QuestionDao;
import com.turingoal.cms.modules.ext.repository.QuestionItemDao;
import com.turingoal.cms.modules.ext.repository.QuestionOptionDao;
import com.turingoal.cms.modules.ext.service.QuestionService;
import com.turingoal.common.annotation.MethodLog;

/**
 * 调查问卷Service
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private QuestionItemDao questionItemDao;
    @Autowired
    private QuestionOptionDao questionOptionDao;

    /**
     * 查询全部 调查问卷
     */
    @MethodLog(name = "查询全部调查问卷", description = "根据条件查询全部的调查问卷，不分页")
    public List<Question> findAll(final QuestionQuery query) {
        return questionDao.find(query);
    }

    /**
     * 分页查询 调查问卷
     */
    @MethodLog(name = "分页查询调查问卷", description = "根据条件分页查询调查问卷")
    public Page<Question> findByPage(final QuestionQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        return (Page<Question>) questionDao.find(query);
    }

    /**
     * 通过id得到一个 调查问卷
     */
    @MethodLog(name = "通过id得到调查问卷", description = "通过id得到一个调查问卷")
    public Question get(final String id) {
        return questionDao.get(id);
    }

    /**
     * 新增 调查问卷
     */
    @MethodLog(name = "新增调查问卷", description = "新增一个调查问卷，返回id")
    public void add(final QuestionForm form) {
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        questionDao.add(form);
    }

    /**
     * 修改 调查问卷
     */
    @MethodLog(name = "修改调查问卷", description = "修改一个调查问卷")
    public int update(final QuestionForm form) {
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        return questionDao.update(form);
    }

    /**
     * 根据id删除一个 调查问卷
     */
    @MethodLog(name = "删除调查问卷", description = "根据id删除一个调查问卷")
    public int delete(final String id) {
        List<QuestionItem> items = questionItemDao.findByQuestionId(id);
        for (QuestionItem item : items) {
            this.deleteItem(item.getId());
        }
        return questionDao.delete(id);
    }

    /**
     * 启用
     */
    @MethodLog(name = "启用调查问卷", description = "根据id启用一个调查问卷")
    public int enable(final String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("enabled", 1);
        return questionDao.changeState(params);
    }

    /**
     * 停用
     */
    @MethodLog(name = "停用调查问卷", description = "根据id停用一个调查问卷")
    public int disable(final String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("enabled", 2);
        return questionDao.changeState(params);
    }

    /**
     * 根据问卷编码获取问卷
     */
    @MethodLog(name = "根据问卷编码获取问卷", description = "根据问卷编码获取问卷")
    public Question findByCodeNum(final QuestionQuery query) {
        Question question = questionDao.findByCodeNum(query);
        question.setQuestionItems(questionItemDao.findByQuestionId(question.getId()));
        if (question.getQuestionItems() != null && question.getQuestionItems().size() > 0) {
            for (QuestionItem qitem : question.getQuestionItems()) {
                qitem.setQuestionOptions(questionOptionDao.findByItemId(qitem.getId()));
            }
        }
        return question;
    }

    /**
     * 通过问卷id得到调查问卷选项
     */
    @MethodLog(name = "通过问卷id得到调查问卷选项", description = "通过问卷id得到调查问卷选项")
    public List<QuestionItem> findItem(final String questionId) {
        return questionItemDao.findByQuestionId(questionId);
    }

    /**
     * 通过选项id获取对应选项内容
     */
    @MethodLog(name = "通过问卷id得到调查问卷选项", description = "通过问卷id得到调查问卷选项")
    public List<QuestionOption> findOption(final String itemId) {
        return questionOptionDao.findByItemId(itemId);
    }

    /**
     * 新增选项信息
     */
    @MethodLog(name = "新增选项信息", description = "新增一条选项信息")
    public void add(final QuestionItemForm form) {
        questionItemDao.add(form);
    }

    /**
     * 新增选项内容
     */
    @MethodLog(name = "新增选项内容", description = "新增一条选项内容")
    public void add(final QuestionOptionForm form) {
        questionOptionDao.add(form);
    }

    /**
     * 修改选项信息
     */
    @MethodLog(name = "修改选项信息", description = "修改一条选项信息")
    public int update(final QuestionItemForm form) {
        return questionItemDao.update(form);
    }

    /**
     * 修改选项内容
     */
    @MethodLog(name = "修改选项内容", description = "修改一条选项内容")
    public int update(final QuestionOptionForm form) {
        return questionOptionDao.update(form);
    }

    /**
     * 删除选项信息
     */
    @MethodLog(name = "删除选项信息", description = "删除一条选项信息")
    public int deleteItem(final String id) {
        List<QuestionOption> options = questionOptionDao.findByItemId(id);
        for (QuestionOption option : options) {
            questionOptionDao.delete(option.getId());
        }
        return questionItemDao.delete(id);
    }

    /**
     * 删除选项内容
     */
    @MethodLog(name = "删除选项内容", description = "删除一条选项内容")
    public int deleteOption(final String id) {
        return questionOptionDao.delete(id);
    }

    /**
     * 根据id得到选项信息
     */
    @MethodLog(name = "根据id得到选项信息", description = "根据id得到选项信息")
    public QuestionItem getItem(final String id) {
        return questionItemDao.get(id);
    }

    /**
     * 根据id得到选项内容信息
     */
    @MethodLog(name = "根据id得到选项内容信息", description = "根据id得到选项内容信息")
    public QuestionOption getOption(final String id) {
        return questionOptionDao.get(id);
    }
}