package com.turingoal.cms.core.service.impl;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.core.domain.SensitiveWord;
import com.turingoal.cms.core.domain.form.SensitiveWordForm;
import com.turingoal.cms.core.domain.query.SensitiveWordQuery;
import com.turingoal.cms.core.repository.SensitiveWordDao;
import com.turingoal.cms.core.service.SysSensitiveWordService;
import com.turingoal.common.annotation.MethodLog;
import com.turingoal.common.constants.ConstantEnabledValue;
import com.turingoal.common.util.lang.StringUtil;

/**
 * 敏感词Service
 */
@Service
public class SysSensitiveWordServiceImpl implements SysSensitiveWordService {
    @Autowired
    private SensitiveWordDao sensitiveWordDao;

    /**
     * 替换敏感词
     */
    public String replace(final String str) {
        String tempStr = str;
        if (!StringUtil.isNullOrBlank(tempStr)) {
            List<SensitiveWord> enabledWords = findEnabled();
            for (SensitiveWord word : enabledWords) {
                tempStr = StringUtils.replace(tempStr, word.getWord(), word.getReplacement());
            }
        }
        return tempStr;
    }

    /**
     * 查询启用的SensitiveWord
     */
    @MethodLog(name = "查询启用的SensitiveWord", description = "根据条件查询启用的SensitiveWord")
    public List<SensitiveWord> findEnabled() {
        return sensitiveWordDao.findEnabled();
    }

    /**
     * 分页查询 SensitiveWord
     */
    @MethodLog(name = "分页查询SensitiveWord", description = "根据条件分页查询SensitiveWord")
    public Page<SensitiveWord> findByPage(final SensitiveWordQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        return (Page<SensitiveWord>) sensitiveWordDao.find(query);
    }

    /**
     * 通过id得到一个 SensitiveWord
     */
    @MethodLog(name = "通过id得到SensitiveWord", description = "通过id得到一个SensitiveWord")
    public SensitiveWord get(final String id) {
        return sensitiveWordDao.get(id);
    }

    /**
     * 新增 SensitiveWord
     */
    @MethodLog(name = "新增SensitiveWord", description = "新增一个SensitiveWord")
    public void add(final SensitiveWordForm form) {
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        sensitiveWordDao.add(form);
    }

    /**
     * 修改 SensitiveWord
     */
    @MethodLog(name = "修改SensitiveWord", description = "修改一个SensitiveWord")
    public int update(final SensitiveWordForm form) {
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        return sensitiveWordDao.update(form);
    }

    /**
     * 根据id删除一个 SensitiveWord
     */
    @MethodLog(name = "删除SensitiveWord", description = "根据id删除一个SensitiveWord")
    public int delete(final String id) {
        return sensitiveWordDao.delete(id);
    }

    /**
     * 根据id删除多个 SensitiveWord
     */
    @MethodLog(name = "删除多个SensitiveWord", description = "根据id删除多个SensitiveWord")
    public int deleteAll(final String ids) {
        return sensitiveWordDao.deleteAll(ids);
    }

    /**
     * 启用
     */
    @MethodLog(name = "启用SensitiveWord", description = "根据id启用一个SensitiveWord")
    public int enable(final String id) {
        return sensitiveWordDao.changeEnabled(id, ConstantEnabledValue.ENABLED_INT);
    }

    /**
     * 停用
     */
    @MethodLog(name = "停用SensitiveWord", description = "根据id停用一个SensitiveWord")
    public int disable(final String id) {
        return sensitiveWordDao.changeEnabled(id, ConstantEnabledValue.DISABLED_INT);
    }
}