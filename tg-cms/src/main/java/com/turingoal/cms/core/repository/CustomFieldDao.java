package com.turingoal.cms.core.repository;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.turingoal.cms.core.domain.CustomField;
import com.turingoal.cms.core.domain.form.CustomFieldForm;
import com.turingoal.cms.core.domain.query.CustomFieldQuery;

/**
 * 自定义字段Dao
 */
public interface CustomFieldDao {

    /**
     * 查询全部 自定义字段
     */
    List<CustomField> find(final CustomFieldQuery query);

    /**
     * 通过id得到一个 自定义字段
     */
    CustomField get(final String id);

    /**
     * 通过模型map得到 自定义字段
     */
    List<CustomFieldForm> findByModel(final Map<String, Object> map);

    /**
     * 新增 自定义字段
     */
    void add(final CustomFieldForm form);

    /**
     * 修改 自定义字段
     */
    int update(final CustomFieldForm form);

    /**
     * 根据id删除一个 自定义字段
     */
    int delete(final String id);

    /**
     * 根据model删除一个 自定义字段
     */
    int deleteByModel(final Map<String, Object> map);

    /**
     * 根据id删除多个 自定义字段
     */
    int deleteAll(final String ids);

    /**
     * 修改是否可用
     */
    int changeEnabled(@Param("id") final String id, @Param("enabled") final Integer enabled);

    /**
     * 校验同一模型下的字段名称、字段标签是否重复
     */
    int validateField(final CustomFieldForm form);

    /**
     * 获取所有模型字段 带输入值 ownerType 模型类型 ownerId 模型id valueOwnerId 文档/栏目/专题 id
     */
    List<CustomField> findFieldAndValueByModel(final CustomFieldQuery query);
}