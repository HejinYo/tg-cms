package com.turingoal.cms.modules.base.service;

import java.io.IOException;
import java.util.List;
import com.turingoal.cms.modules.base.domain.Template;
import com.turingoal.cms.modules.base.domain.form.TemplateForm;
import com.turingoal.cms.modules.base.domain.query.TemplateQuery;

/**
 * TemplateService
 */
public interface TemplateService {

    /**
     * 查询全部 Template
     */
    List<Template> findAll(final TemplateQuery query);

    /**
     * 通过id得到一个 Template
     */
    Template get(final String id);

    /**
     * 新增 Template
     * 
     * @throws IOException
     */
    void add(final TemplateForm form) throws IOException;

    /**
     * 修改 Template
     */
    int update(final TemplateForm form);

    /**
     * 根据id删除一个 Template
     */
    int delete(final String id);
}