package com.turingoal.cms.modules.base.service;

import java.util.List;
import com.turingoal.cms.modules.base.domain.Attr;
import com.turingoal.cms.modules.base.domain.form.AttrForm;
import com.turingoal.cms.modules.base.domain.query.AttrQuery;

/**
 * 属性Service
 */
public interface AttrService {

    /**
     * 查询全部 属性
     */
    List<Attr> findAll(final AttrQuery query);

    /**
     * 通过id得到一个 属性
     */
    Attr get(final String id);

    /**
     * 根据文章id获取属性
     */
    List<Attr> findByInfoId(final String id);

    /**
     * 通过codeNum得到一个 属性
     */
    Attr getByCode(final String codeNum);

    /**
     * 新增 属性
     */
    void add(final AttrForm form);

    /**
     * 修改 属性
     */
    int update(final AttrForm form);

    /**
     * 根据id删除一个 属性
     */
    int delete(final String id);
}