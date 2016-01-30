package com.turingoal.cms.core.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.turingoal.cms.core.domain.CustomField;
import com.turingoal.cms.core.domain.form.CustomFieldForm;
import com.turingoal.cms.core.domain.query.CustomFieldQuery;
import com.turingoal.cms.core.repository.CustomFieldDao;
import com.turingoal.cms.core.service.CustomFieldService;
import com.turingoal.cms.modules.commons.SystemFields;
import com.turingoal.common.annotation.MethodLog;

/**
 * CustomFieldService
 */
@Service
public class CustomFieldServiceImpl implements CustomFieldService {
    @Autowired
    private CustomFieldDao customFieldDao;

    /**
     * 查询全部 CustomField
     */
    @MethodLog(name = "查询全部CustomField", description = "根据条件查询全部的CustomField，不分页")
    public List<CustomField> findAll(final CustomFieldQuery query) {
        return customFieldDao.find(query);
    }

    /**
     * 分页查询 CustomField
     */
    @MethodLog(name = "分页查询CustomField", description = "根据条件分页查询CustomField")
    public Page<CustomField> findByPage(final CustomFieldQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        return (Page<CustomField>) customFieldDao.find(query);
    }

    /**
     * 通过id得到一个 CustomField
     */
    @MethodLog(name = "通过id得到CustomField", description = "通过id得到一个CustomField")
    public CustomField get(final String id) {
        return customFieldDao.get(id);
    }

    /**
     * 新增 CustomField
     */
    @MethodLog(name = "新增CustomField", description = "新增一个CustomField，返回id")
    public void add(final CustomFieldForm form) {
        if (form.getInnerType() == 1) {
            String name = "cus_" + getTypeStr(form.getType()) + "_" + form.getFieldName();
            form.setFieldName(name);
        }
        customFieldDao.add(form);
    }

    /**
     * 修改 CustomField
     */
    @MethodLog(name = "修改CustomField", description = "修改一个CustomField")
    public int update(final CustomFieldForm form) {
        if (form.getInnerType() == 1) {
            String name = "cus_" + getTypeStr(form.getType()) + "_" + form.getFieldName();
            form.setFieldName(name);
        }
        return customFieldDao.update(form);
    }

    /**
     * 根据id删除一个 CustomField
     */
    @MethodLog(name = "删除CustomField", description = "根据id删除一个CustomField")
    public int delete(final String id) {
        return customFieldDao.delete(id);
    }

    /**
     * 根据id删除多个 CustomField
     */
    @MethodLog(name = "删除多个CustomField", description = "根据id删除多个CustomField")
    public int deleteAll(final String ids) {
        return customFieldDao.deleteAll(ids);
    }

    /**
     * 校验CustomField
     */
    @MethodLog(name = "校验CustomField", description = "校验CustomField")
    public Boolean validateField(final CustomFieldForm form) {
        int count = customFieldDao.validateField(form);
        return count > 0;
    }

    /**
     * 获取所有模型字段 带输入值 ownerType 模型类型 ownerId 模型id valueOwnerId 文档/栏目/专题 id
     */
    public List<CustomField> findFieldAndValueByModel(final CustomFieldQuery query) {
        return customFieldDao.findFieldAndValueByModel(query);
    }

    /**
     * 根据字段类型返回对应字符串
     */
    public String getTypeStr(final Integer type) {
        if (type == 1) {
            return "str";
        } else if (type == 2) {
            return "date";
        } else if (type == 3) {
            return "str";
        } else if (type == 4) {
            return "str";
        } else if (type == 5) {
            return "str";
        } else if (type == 6) {
            return "blob";
        } else if (type == 7) {
            return "str";
        } else if (type == 8) {
            return "str";
        } else if (type == 9) {
            return "str";
        } else if (type == 10) {
            return "str";
        } else {
            return "str";
        }
    }

    /**
     * 新增系统字段
     */
    @MethodLog(name = "新增系统字段", description = "新增系统字段")
    public void addSysField(final String fieldName, final String ownerType, final String ownerId) {
        CustomFieldForm form = new CustomFieldForm();
        switch (ownerType) {
        case "infoModel":
            form = SystemFields.SYS_INFO_FIELD.get(fieldName);
            break;
        case "nodeModel":
            form = SystemFields.SYS_NODE_FIELD.get(fieldName);
            break;
        case "specialModel":
            form = SystemFields.SYS_SPECIAL_FIELD.get(fieldName);
            break;
        default:
            break;
        }
        form.setOwnerId(ownerId);
        form.setOwnerType(ownerType);
        customFieldDao.add(form);
    }

    /**
     * 删除 系统字段
     */
    @MethodLog(name = "删除 文章、专题关系", description = "删除 文章、专题关系")
    public int deleteSysField(final CustomFieldForm form) {
        customFieldDao.delete(form.getId());
        return 0;
    }

    /**
     * 获取所有系统模型字段
     */
    @MethodLog(name = "复制模型", description = "复制一个模型")
    public List<CustomFieldForm> findSysField(final String modelId, final String modelType) {
        Map<String, CustomFieldForm> fieldMap = new HashMap<String, CustomFieldForm>();
        // 根据模型类型获取对应系统字段
        if (modelType.startsWith("info")) {
            fieldMap = new HashMap<String, CustomFieldForm>(SystemFields.SYS_INFO_FIELD); // 获取文档系统模型字段
        } else if (modelType.startsWith("node")) {
            fieldMap = new HashMap<String, CustomFieldForm>(SystemFields.SYS_NODE_FIELD); // 获取栏目系统模型字段
        } else if (modelType.startsWith("special")) {
            fieldMap = new HashMap<String, CustomFieldForm>(SystemFields.SYS_SPECIAL_FIELD); // 获取专题系统模型字段
        }
        // 根据模型id、模型类型或已使用字段
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ownerId", modelId);
        map.put("ownerType", modelType);
        List<CustomFieldForm> list = customFieldDao.findByModel(map);
        // 判断系统字段是否被使用，如使用则移除
        for (CustomFieldForm custom : list) {
            CustomFieldForm customField = fieldMap.get(custom.getFieldName());
            if (customField != null) {
                fieldMap.remove(custom.getFieldName());
            }
        }
        return new ArrayList<CustomFieldForm>(fieldMap.values());
    }
}