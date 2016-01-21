package com.turingoal.cms.modules.base.repository;

import java.util.List;
import com.turingoal.cms.modules.base.domain.Template;
import com.turingoal.cms.modules.base.domain.form.TemplateForm;
import com.turingoal.cms.modules.base.domain.query.TemplateQuery;

/**
 * TemplateDao
 */
public interface TemplateDao {

    /**
     * 查询 Template
     */
    List<Template> find(final TemplateQuery query);

    /**
     * 通过id得到一个 Template
     */
    Template get(final String id);

    /**
     * 新增 Template
     */
    void add(final TemplateForm form);

    /**
     * 修改 Template
     */
    int update(final TemplateForm form);

    /**
     * 根据id删除一个 Template
     */
    int delete(final String id);
}