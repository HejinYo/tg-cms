package com.turingoal.cms.modules.ext.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.modules.ext.domain.ScoreRecord;
import com.turingoal.cms.modules.ext.domain.form.ScoreRecordForm;
import com.turingoal.cms.modules.ext.domain.query.ScoreRecordQuery;
import com.turingoal.cms.modules.ext.repository.ScoreRecordDao;
import com.turingoal.cms.modules.ext.service.ScoreRecordService;
import com.turingoal.common.annotation.MethodLog;

/**
 * 计分牌Service
 */
@Service
public class ScoreRecordServiceImpl implements ScoreRecordService {
    @Autowired
    private ScoreRecordDao scoreRecordDao;

    /**
     * 查询全部 计分牌
     */
    @MethodLog(name = "查询全部计分牌", description = "根据条件查询全部的计分牌，不分页")
    public List<ScoreRecord> findAll(final ScoreRecordQuery query) {
        return scoreRecordDao.find(query);
    }

    /**
     * 分页查询 计分牌
     */
    @MethodLog(name = "分页查询计分牌", description = "根据条件分页查询计分牌")
    public Page<ScoreRecord> findByPage(final ScoreRecordQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        return (Page<ScoreRecord>) scoreRecordDao.find(query);
    }

    /**
     * 通过id得到一个 计分牌
     */
    @MethodLog(name = "通过id得到计分牌", description = "通过id得到一个计分牌")
    public ScoreRecord get(final String id) {
        return scoreRecordDao.get(id);
    }

    /**
     * 新增 计分牌
     */
    @MethodLog(name = "新增计分牌", description = "新增一个计分牌，返回id")
    public void add(final ScoreRecordForm form) {
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        scoreRecordDao.add(form);
    }

    /**
     * 修改 计分牌
     */
    @MethodLog(name = "修改计分牌", description = "修改一个计分牌")
    public int update(final ScoreRecordForm form) {
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        return scoreRecordDao.update(form);
    }

    /**
     * 根据id删除一个 计分牌
     */
    @MethodLog(name = "删除计分牌", description = "根据id删除一个计分牌")
    public int delete(final String id) {
        return scoreRecordDao.delete(id);
    }
}