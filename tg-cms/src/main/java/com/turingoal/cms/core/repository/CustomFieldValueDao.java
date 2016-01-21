package com.turingoal.cms.core.repository;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.turingoal.cms.core.domain.CustomFieldValue;
import com.turingoal.cms.core.domain.form.CustomFieldValueForm;
import com.turingoal.cms.core.domain.query.CustomFieldValueQuery;

/**
 * 自定义字段值Dao
 */
public interface CustomFieldValueDao {

    /**
     * 查询全部 自定义字段值
     */
    List<CustomFieldValue> find(final CustomFieldValueQuery query);

    /**
     * 通过id得到一个 自定义字段值
     */
    CustomFieldValue get(final String id);

    /**
     * 新增 自定义字段值
     */
    void add(final CustomFieldValueForm form);

    /**
     * 修改 自定义字段值
     */
    int update(final CustomFieldValueForm form);

    /**
     * 根据id删除一个 自定义字段值
     */
    int delete(final String id);

    /**
     * 根据id删除多个自定义字段值
     */
    int deleteAll(final String ids);

    /**
     * 修改是否可用
     */
    int changeEnabled(@Param("id") final String id, @Param("enabled") final Integer enabled);

    /**
     * 根据model删除用户自定义值
     */
    int deleteByModel(Map<String, Object> params);

    /**
     * findByOwner
     */
    List<CustomFieldValue> findByOwner(final CustomFieldValueQuery query);
}