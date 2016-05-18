package com.turingoal.cms.modules.base.repository;

import java.util.List;
import java.util.Map;
import com.turingoal.cms.modules.base.domain.Model;
import com.turingoal.cms.modules.base.domain.form.ModelForm;
import com.turingoal.cms.modules.base.domain.query.ModelQuery;

/**
 * ModelDao
 */
public interface ModelDao {

    /**
     * 查询全部 Model
     */
    List<Model> find(final ModelQuery query);

    /**
     * 通过id得到一个 Model
     */
    Model get(final String id);

    /**
     * 新增 Model
     */
    void add(final ModelForm form);

    /**
     * 修改 Model
     */
    int update(final ModelForm form);

    /**
     * 根据id删除一个 Model
     */
    int delete(final String id);

    /**
     * 获取所有模型字段
     */
    List<Map<String, Object>> findFieldByModel(final Integer id);
}