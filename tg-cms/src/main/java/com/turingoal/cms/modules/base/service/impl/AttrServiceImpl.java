package com.turingoal.cms.modules.base.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.modules.base.domain.Attr;
import com.turingoal.cms.modules.base.domain.form.AttrForm;
import com.turingoal.cms.modules.base.domain.query.AttrQuery;
import com.turingoal.cms.modules.base.repository.AttrDao;
import com.turingoal.cms.modules.base.service.AttrService;
import com.turingoal.common.annotation.MethodLog;

/**
 * 属性Service
 */
@Service
public class AttrServiceImpl implements AttrService {
    @Autowired
    private AttrDao attrDao;

    /**
     * 查询全部 属性
     */
    @MethodLog(name = "查询全部属性", description = "根据条件查询全部的属性，不分页")
    public List<Attr> findAll(final AttrQuery query) {
        return attrDao.find(query);
    }

    /**
     * 通过codeNum得到一个 属性
     */
    @MethodLog(name = "通过codeNum得到一个 属性", description = "通过codeNum得到一个 属性")
    public Attr getByCode(final String codeNum) {
        return attrDao.getByCode(codeNum);
    }

    /**
     * 通过id得到一个 属性
     */
    @MethodLog(name = "通过id得到属性", description = "通过id得到一个属性")
    public Attr get(final String id) {
        Attr attr = attrDao.get(id);
        //attr.setImagePath(SystemHelper.getGlobal().getContextPath() + attr.getImagePath());
        return attr;
    }

    /**
     * 根据文章id获取属性
     */
    @MethodLog(name = "根据文章id获取属性", description = "根据文章id获取属性")
    public List<Attr> findByInfoId(final String id) {
        List<Attr> attrs = attrDao.findByInfoId(id);
        for (Attr attr : attrs) {
            attr.setImagePath(SystemHelper.getGlobal().getContextPath() + attr.getImagePath());
        }
        return attrs;
    }

    /**
     * 新增 属性
     */
    @MethodLog(name = "新增属性", description = "新增一个属性")
    public void add(final AttrForm form) {
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        attrDao.add(form);
    }

    /**
     * 修改 属性
     */
    @MethodLog(name = "修改属性", description = "修改一个属性")
    public int update(final AttrForm form) {
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        return attrDao.update(form);
    }

    /**
     * 根据id删除一个 Attr
     */
    @MethodLog(name = "删除属性", description = "根据id删除一个属性")
    public int delete(final String id) {
        return attrDao.delete(id);
    }
}