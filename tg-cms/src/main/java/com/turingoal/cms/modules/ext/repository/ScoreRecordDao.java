package com.turingoal.cms.modules.ext.repository;

import java.util.List;
import com.turingoal.cms.modules.ext.domain.ScoreRecord;
import com.turingoal.cms.modules.ext.domain.form.ScoreRecordForm;
import com.turingoal.cms.modules.ext.domain.query.ScoreRecordQuery;

/**
 * 计分牌Dao
 */
public interface ScoreRecordDao {

    /**
     * 查询 计分牌
     */
    List<ScoreRecord> find(final ScoreRecordQuery query);

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