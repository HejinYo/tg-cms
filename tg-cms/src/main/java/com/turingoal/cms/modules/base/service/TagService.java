package com.turingoal.cms.modules.base.service;

import com.github.pagehelper.Page;
import com.turingoal.cms.modules.base.domain.Tag;
import com.turingoal.cms.modules.base.domain.form.TagForm;
import com.turingoal.cms.modules.base.domain.query.TagQuery;

/**
 * TagService
 */
public interface TagService {

    /**
     * 分页查询 Tag
     */
    Page<Tag> findByPage(final TagQuery query);

    /**
     * 通过id得到一个 Tag
     */
    Tag get(final String id);

    /**
     * 新增 Tag
     */
    void add(final TagForm form);

    /**
     * 修改 Tag
     */
    int update(final TagForm form);

    /**
     * 根据id删除一个 Tag
     */
    int delete(final String id);

}