package com.turingoal.cms.modules.base.service;

import java.io.IOException;
import java.util.List;
import com.turingoal.cms.modules.base.domain.Template;
import com.turingoal.cms.modules.base.domain.form.TemplateForm;
import com.turingoal.cms.modules.base.domain.query.TemplateQuery;

/**
 * 模板Service
 */
public interface TemplateService {

    /**
     * 查询全部 模板
     */
    List<Template> findAll(final TemplateQuery query);

    /**
     * 通过id得到一个 模板
     */
    Template get(final String id);

    /**
     * 新增 模板
     */
    void add(final TemplateForm form) throws IOException;

    /**
     * 修改 模板
     */
    int update(final TemplateForm form);

    /**
     * 根据id删除一个 模板
     */
    int delete(final String id);
}