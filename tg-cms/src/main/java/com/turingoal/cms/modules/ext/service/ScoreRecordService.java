package com.turingoal.cms.modules.ext.service;

import java.util.List;
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.ext.domain.ScoreRecord;
import com.turingoal.cms.modules.ext.domain.form.ScoreRecordForm;
import com.turingoal.cms.modules.ext.domain.query.ScoreRecordQuery;

/**
 * 计分牌Service
 */
public interface ScoreRecordService {

    /**
     * 查询全部 计分牌
     */
    List<ScoreRecord> findAll(final ScoreRecordQuery query);

    /**
     * 分页查询 计分牌
     */
    Page<ScoreRecord> findByPage(final ScoreRecordQuery query);

    /**
     * 通过id得到一个 计分牌
     */
    ScoreRecord get(final String id);

    /**
     * 新增 计分牌
     */
    void add(final ScoreRecordForm form);

    /**
     * 修改 计分牌
     */
    int update(final ScoreRecordForm form);

    /**
     * 根据id删除一个 计分牌
     */
    int delete(final String id);
}