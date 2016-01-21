package com.turingoal.cms.modules.base.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.modules.base.domain.Template;
import com.turingoal.cms.modules.base.domain.form.TemplateForm;
import com.turingoal.cms.modules.base.domain.query.TemplateQuery;
import com.turingoal.cms.modules.base.repository.TemplateDao;
import com.turingoal.cms.modules.base.service.TemplateService;
import com.turingoal.common.annotation.MethodLog;
import com.turingoal.common.util.io.FileUtil;

/**
 * 模板Service
 */
@Service
public class TemplateServiceImpl implements TemplateService {
    @Autowired
    private TemplateDao templateDao;

    /**
     * 查询全部 模板
     */
    @MethodLog(name = "查询全部模板", description = "根据条件查询全部的模板，不分页")
    public List<Template> findAll(final TemplateQuery query) {
        return templateDao.find(query);
    }

    /**
     * 通过id得到一个 模板
     */
    @MethodLog(name = "通过id得到模板", description = "通过id得到一个模板")
    public Template get(final String id) {
        return templateDao.get(id);
    }

    /**
     * 新增 模板
     */
    @MethodLog(name = "新增模板", description = "新增一个模板")
    public void add(final TemplateForm form) throws IOException {
        FileUtil.createParentDirs(form.getContentPath() + "/template/" + form.getCodeNum());
        FileUtils.copyDirectory(new File(form.getContentPath() + "/template/default"), new File(form.getContentPath() + "/template/" + form.getCodeNum()), true);
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        templateDao.add(form);
    }

    /**
     * 修改 模板
     */
    @MethodLog(name = "修改模板", description = "修改一个模板")
    public int update(final TemplateForm form) {
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        return templateDao.update(form);
    }

    /**
     * 根据id删除一个 模板
     */
    @MethodLog(name = "删除模板", description = "根据id删除一个模板")
    public int delete(final String id) {
        return templateDao.delete(id);
    }
}