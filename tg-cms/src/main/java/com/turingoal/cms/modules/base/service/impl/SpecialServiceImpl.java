package com.turingoal.cms.modules.base.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.primitives.Doubles;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.core.domain.form.CustomFieldValueForm;
import com.turingoal.cms.core.repository.CustomFieldValueDao;
import com.turingoal.cms.modules.base.domain.Special;
import com.turingoal.cms.modules.base.domain.form.SpecialForm;
import com.turingoal.cms.modules.base.domain.query.SpecialQuery;
import com.turingoal.cms.modules.base.repository.SpecialDao;
import com.turingoal.cms.modules.base.service.SpecialService;
import com.turingoal.common.annotation.MethodLog;

/**
 * 专题Service
 */
@Service
public class SpecialServiceImpl implements SpecialService {
    @Autowired
    private SpecialDao specialDao;
    @Autowired
    private CustomFieldValueDao customFieldValueDao;

    /**
     * 查询全部 专题
     */
    @MethodLog(name = "查询全部专题", description = "根据条件查询全部的专题，不分页")
    public List<Special> findAll(final SpecialQuery query) {
        return specialDao.find(query);
    }

    /**
     * 分页查询 Special
     */
    @MethodLog(name = "分页查询专题", description = "根据条件分页查询专题")
    public Page<Special> findByPage(final SpecialQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        return (Page<Special>) specialDao.find(query);
    }

    /**
     * 通过id得到一个 专题
     */
    @MethodLog(name = "通过id得到专题", description = "通过id得到一个专题")
    public Special get(final String id) {
        return specialDao.get(id);
    }

    /**
     * 更新自定义字段值
     */
    private void updateCusFieldValue(final SpecialForm form, final Map<String, String> cusMap) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("ownerType", "specialModel");
        params.put("ownerId", form.getId());
        customFieldValueDao.deleteByModel(params);

        for (String keyStr : cusMap.keySet()) {
            CustomFieldValueForm cusForm = new CustomFieldValueForm();
            String prefix = keyStr.substring(0, keyStr.lastIndexOf("_") + 1);
            cusForm.setKeyStr(keyStr);
            switch (prefix) {
            case "cus_str_":
                cusForm.setValueStr(cusMap.get(keyStr));
                break;
            case "cus_blob_":
                cusForm.setValueForLongText(cusMap.get(keyStr));
                break;
            case "cus_date_":
                cusForm.setValueForDate(DateTime.parse(cusMap.get(keyStr).toString()).toDate());
                break;
            case "cus_num_":
                cusForm.setValueForDouble(Doubles.tryParse(cusMap.get(keyStr).toString()));
                break;
            default:
                break;
            }
            cusForm.setOwnerId(form.getId());
            cusForm.setOwnerType("specialModel");
            customFieldValueDao.add(cusForm);
        }
    }

    /**
     * 新增 专题
     */
    @MethodLog(name = "新增专题", description = "新增一个专题")
    public void add(final SpecialForm form, final Map<String, String> cusMap) {
        form.setRefersCount(0);
        form.setViewsCount(0);
        form.setWithImage(0);
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        specialDao.add(form);
        updateCusFieldValue(form, cusMap);
    }

    /**
     * 修改 专题
     */
    @MethodLog(name = "修改专题", description = "修改一个专题")
    public int update(final SpecialForm form, final Map<String, String> cusMap) {
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        int result = specialDao.update(form);
        updateCusFieldValue(form, cusMap);
        return result;
    }

    /**
     * 根据id删除一个 专题
     */
    @MethodLog(name = "删除专题", description = "根据id删除一个专题")
    public int delete(final String id) {
        return specialDao.delete(id);
    }

    /**
     * 启用
     */
    @MethodLog(name = "启用专题", description = "根据id启用一个专题")
    public int enable(final String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("state", 1);
        return specialDao.changeState(params);
    }

    /**
     * 停用
     */
    @MethodLog(name = "停用专题", description = "根据id停用一个专题")
    public int disable(final String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("state", 2);
        return specialDao.changeState(params);
    }
}