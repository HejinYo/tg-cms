package com.turingoal.cms.modules.ext.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.modules.ext.domain.ScoreGroup;
import com.turingoal.cms.modules.ext.domain.ScoreItem;
import com.turingoal.cms.modules.ext.domain.form.ScoreGroupForm;
import com.turingoal.cms.modules.ext.domain.form.ScoreItemForm;
import com.turingoal.cms.modules.ext.domain.query.ScoreGroupQuery;
import com.turingoal.cms.modules.ext.repository.ScoreGroupDao;
import com.turingoal.cms.modules.ext.repository.ScoreItemDao;
import com.turingoal.cms.modules.ext.service.ScoreGroupService;
import com.turingoal.common.annotation.MethodLog;

/**
 * 计分组Service
 */
@Service
public class ScoreGroupServiceImpl implements ScoreGroupService {
    @Autowired
    private ScoreGroupDao scoreGroupDao;
    @Autowired
    private ScoreItemDao scoreItemDao;

    /**
     * 查询全部 计分组
     */
    @MethodLog(name = "查询全部计分组", description = "根据条件查询全部的计分组，不分页")
    public List<ScoreGroup> findAll(final ScoreGroupQuery query) {
        return scoreGroupDao.find(query);
    }

    /**
     * 通过id得到一个 计分组
     */
    @MethodLog(name = "通过id得到计分组", description = "通过id得到一个计分组")
    public ScoreGroup get(final String id) {
        return scoreGroupDao.get(id);
    }

    /**
     * 新增 计分组
     */
    @MethodLog(name = "新增计分组", description = "新增一个计分组，返回id")
    public void add(final ScoreGroupForm form) {
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        scoreGroupDao.add(form);
    }

    /**
     * 修改 计分组
     */
    @MethodLog(name = "修改计分组", description = "修改一个计分组")
    public int update(final ScoreGroupForm form) {
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        return scoreGroupDao.update(form);
    }

    /**
     * 根据id删除一个 计分组
     */
    @MethodLog(name = "删除计分组", description = "根据id删除一个计分组")
    public int delete(final String id) {
        return scoreGroupDao.delete(id);
    }

    /**
     * 根据计分组id获取计分选项信息
     */
    @MethodLog(name = "根据计分组id获取计分选项信息", description = "根据计分组id获取计分选项信息")
    public List<ScoreItem> findItem(final String groupId) {
        return scoreItemDao.getById(groupId);
    }

    /**
     * 新增计分组选项信息
     */
    @MethodLog(name = "新增计分组选项信息", description = "新增计分组选项信息")
    public void addItem(final ScoreItemForm form) {
        scoreItemDao.add(form);
    }

    /**
     * 根据id获取计分组选项信息
     */
    @MethodLog(name = "根据id获取计分组选项信息", description = "根据id获取计分组选项信息")
    public ScoreItem getItem(final String id) {
        return scoreItemDao.get(id);
    }

    /**
     * 修改计分组选项 信息
     */
    @MethodLog(name = "修改计分组选项 信息", description = "修改计分组选项 信息")
    public void update(final ScoreItemForm form) {
        scoreItemDao.update(form);
    }

    /**
     * 根据id删除一条计分组选项信息
     */
    @MethodLog(name = "根据id删除一条计分组选项信息", description = "根据id删除一条计分组选项信息")
    public void deleteItem(final String id) {
        scoreItemDao.delete(id);
    }

}