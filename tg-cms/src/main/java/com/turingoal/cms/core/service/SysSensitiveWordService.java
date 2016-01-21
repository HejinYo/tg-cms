package com.turingoal.cms.core.service;

import com.github.pagehelper.Page;
import com.turingoal.cms.core.domain.SensitiveWord;
import com.turingoal.cms.core.domain.form.SensitiveWordForm;
import com.turingoal.cms.core.domain.query.SensitiveWordQuery;

/**
 * SensitiveWordService
 */
public interface SysSensitiveWordService {

    /**
     * 替换敏感词
     */
    String replace(String str);

    /**
     * 分页查询 SensitiveWord
     */
    Page<SensitiveWord> findByPage(final SensitiveWordQuery query);

    /**
     * 通过id得到一个 SensitiveWord
     */
    SensitiveWord get(final String id);

    /**
     * 新增 SensitiveWord
     */
    void add(final SensitiveWordForm form);

    /**
     * 修改 SensitiveWord
     */
    int update(final SensitiveWordForm form);

    /**
     * 根据id删除一个 SensitiveWord
     */
    int delete(final String id);

    /**
     * 根据id删除多个 SensitiveWord
     */
    int deleteAll(final String ids);

    /**
     * 启用
     */
    int enable(final String id);

    /**
     * 停用
     */
    int disable(final String id);
}