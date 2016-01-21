package com.turingoal.cms.core.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.core.domain.Dict;
import com.turingoal.cms.core.domain.form.DictForm;
import com.turingoal.cms.core.domain.query.DictQuery;
import com.turingoal.cms.core.repository.DictDao;
import com.turingoal.cms.core.service.SysDictService;
import com.turingoal.common.annotation.MethodLog;
import com.turingoal.common.constants.ConstantEnabledValue;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.exception.ExceptionCode;

/**
 * 数据字典Service
 */
@Service
public class SysDictServiceImpl implements SysDictService {
    @Autowired
    private DictDao dictDao;

    /**
     * 根据字典类型查询启用的数据字典
     */
    @MethodLog(name = " 根据字典类型查询启用的数据字典", description = " 根据字典类型查询启用的数据字典")
    public List<Dict> findEnabledByType(final String dictType) {
        return dictDao.findEnabledByType(dictType);
    }

    /**
     * 分页查询数据字典
     */
    @MethodLog(name = "分页查询数据字典", description = "分页查询数据字典")
    public Page<Dict> findByPage(final DictQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        return (Page<Dict>) dictDao.find(query);
    }

    /**
     * ͨ根据id获得一个数据字典
     */
    @MethodLog(name = "ͨ根据id获得一个数据字典", description = "ͨ根据id获得一个数据字典")
    public Dict get(final String id) {
        return dictDao.get(id);
    }

    /**
     * 新增数据字典
     */
    @MethodLog(name = "新增数据字典", description = "新增数据字典")
    public void add(final DictForm form) {
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        dictDao.add(form);
    }

    /**
     * 修改数据字典
     */
    @MethodLog(name = "修改数据字典", description = "修改数据字典")
    public int update(final DictForm form) throws BusinessException {
        // 检测该字段是否可编辑
        if (dictDao.checkEditable(form.getId()) != 1) {
            throw new BusinessException(ExceptionCode.CODE_1000);
        } else {
            form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
            return dictDao.update(form);
        }
    }

    /**
     * 根据id删除数据字典
     */
    @MethodLog(name = "根据id删除数据字典", description = "根据id删除数据字典")
    public int delete(final String id) throws BusinessException {
        if (dictDao.checkEditable(id) != 1) {
            throw new BusinessException(ExceptionCode.CODE_1000);
        } else {
            return dictDao.delete(id);
        }
    }

    /**
     * 根据id启用数据字典
     */
    @MethodLog(name = "根据id启用数据字典", description = "根据id启用数据字典")
    public int enable(final String id) throws BusinessException {
        if (dictDao.checkEditable(id) != 1) {
            throw new BusinessException(ExceptionCode.CODE_1000);
        } else {
            return dictDao.changeEnabled(id, ConstantEnabledValue.ENABLED_INT);
        }
    }

    /**
     * 根据id停用数据字典
     */
    @MethodLog(name = "ͣ根据id停用数据字典", description = "根据id停用数据字典")
    public int disable(final String id) throws BusinessException {
        if (dictDao.checkEditable(id) != 1) {
            throw new BusinessException(ExceptionCode.CODE_1000);
        } else {
            return dictDao.changeEnabled(id, ConstantEnabledValue.DISABLED_INT);
        }
    }
}