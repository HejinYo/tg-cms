package com.turingoal.cms.core.service;

import java.util.List;
import com.turingoal.cms.core.domain.CustomField;
import com.turingoal.cms.core.domain.form.CustomFieldForm;
import com.turingoal.cms.core.domain.query.CustomFieldQuery;

/**
 * CustomFieldService
 */
public interface CustomFieldService {

    /**
     * 查询全部 CustomField
     */
    List<CustomField> findAll(final CustomFieldQuery query);

    /**
     * 分页查询 CustomField
     */
    List<CustomField> findByPage(final CustomFieldQuery query);

    /**
     * 通过id得到一个 CustomField
     */
    CustomField get(final String id);

    /**
     * 新增 CustomField
     */
    void add(final CustomFieldForm form);

    /**
     * 修改 CustomField
     */
    int update(final CustomFieldForm form);

    /**
     * 根据id删除一个 CustomField
     */
    int delete(final String id);

    /**
     * 根据id删除多个 CustomField
     */
    int deleteAll(final String ids);

    /**
     * 校验CustomField
     */
    Boolean validateField(final CustomFieldForm form);

    /**
     * 获取所有模型字段 带输入值 ownerType 模型类型 ownerId 模型id valueOwnerId 文档/栏目/专题 id
     */
    List<CustomField> findFieldAndValueByModel(final CustomFieldQuery query);

    /**
     * 新增系统字段
     */
    void addSysField(final String fieldName, final String ownerType, final String ownerId);

    /**
     * 删除 系统字段
     */
    int deleteSysField(final CustomFieldForm form);

    /**
     * 查询系统字段
     */
    List<CustomFieldForm> findSysField(String modelId, String modelType);
}