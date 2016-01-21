package com.turingoal.cms.core.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.turingoal.cms.core.domain.SensitiveWord;
import com.turingoal.cms.core.domain.form.SensitiveWordForm;
import com.turingoal.cms.core.domain.query.SensitiveWordQuery;

/**
 * 敏感词Dao
 */
public interface SensitiveWordDao {
    /**
     * 查询全部 启用的敏感词
     */
    List<SensitiveWord> findEnabled();

    /**
     * 查询 敏感词
     */
    List<SensitiveWord> find(final SensitiveWordQuery query);

    /**
     * 通过id得到一个 敏感词
     */
    SensitiveWord get(final String id);

    /**
     * 新增 敏感词
     */
    void add(final SensitiveWordForm form);

    /**
     * 修改 敏感词
     */
    int update(final SensitiveWordForm form);

    /**
     * 根据id删除一个 敏感词
     */
    int delete(final String id);

    /**
     * 根据id删除多个 敏感词
     */
    int deleteAll(final String ids);

    /**
     * 修改是否可用
     */
    int changeEnabled(@Param("id") final String id, @Param("enabled") final Integer enabled);
}