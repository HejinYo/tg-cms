package com.turingoal.cms.modules.base.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.core.domain.form.CustomFieldForm;
import com.turingoal.cms.core.repository.CustomFieldDao;
import com.turingoal.cms.modules.base.domain.Model;
import com.turingoal.cms.modules.base.domain.form.ModelForm;
import com.turingoal.cms.modules.base.domain.query.ModelQuery;
import com.turingoal.cms.modules.base.repository.ModelDao;
import com.turingoal.cms.modules.base.service.ModelService;
import com.turingoal.common.annotation.MethodLog;

/**
 * 模型Service
 */
@Service
public class ModelServiceImpl implements ModelService {
    @Autowired
    private ModelDao modelDao;
    @Autowired
    private CustomFieldDao customFieldDao;

    /**
     * 查询全部 模型
     */
    @MethodLog(name = "查询全部模型", description = "根据条件查询全部的模型")
    public List<Model> findAll(final ModelQuery query) {
        return modelDao.find(query);
    }

    /**
     * 通过id得到一个 模型
     */
    @MethodLog(name = "通过id得到模型", description = "通过id得到一个模型")
    public Model get(final String id) {
        return modelDao.get(id);
    }

    /**
     * 新增 模型
     */
    @MethodLog(name = "新增模型", description = "新增一个模型，返回id")
    public void add(final ModelForm form) {
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        modelDao.add(form);
    }

    /**
     * 修改 模型
     */
    @MethodLog(name = "修改模型", description = "修改一个模型")
    public int update(final ModelForm form) {
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        return modelDao.update(form);
    }

    /**
     * 根据id删除一个 模型
     */
    @MethodLog(name = "删除模型", description = "根据id删除一个模型")
    public int delete(final String id) {
        // 删除模型前，优先删除模型字段
        Map<String, Object> map = new HashMap<String, Object>();
        Model model = this.get(id);
        map.put("modelType", model.getType() + "Model");
        map.put("modelId", id);
        customFieldDao.deleteByModel(map);
        // 删除模型
        return modelDao.delete(id);
    }

    /**
     * 复制模型
     */
    @MethodLog(name = "复制模型", description = "复制一个模型")
    public void addAndCopy(final ModelForm form) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ownerId", form.getId());
        map.put("ownerType", form.getType() + "Model");
        form.setId(UUID.randomUUID().toString());
        // 新增模型
        modelDao.add(form);
        // 复制指定模型下的字段至新录入的模型下
        List<CustomFieldForm> list = customFieldDao.findByModel(map);
        for (CustomFieldForm custom : list) {
            custom.setId(UUID.randomUUID().toString());
            custom.setOwnerType(form.getType() + "Model");
            custom.setOwnerId(form.getId());
            customFieldDao.add(custom);
        }
    }

    /**
     * 根据类型查询模型
     */
    @Override
    public List<Model> findByType(final String type) {
        ModelQuery query = new ModelQuery();
        query.setType(type);
        return findAll(query);
    }
}