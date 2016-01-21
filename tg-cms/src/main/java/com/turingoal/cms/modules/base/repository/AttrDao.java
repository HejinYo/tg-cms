package com.turingoal.cms.modules.base.repository;

import java.util.List;
import com.turingoal.cms.modules.base.domain.Attr;
import com.turingoal.cms.modules.base.domain.form.AttrForm;
import com.turingoal.cms.modules.base.domain.query.AttrQuery;

/**
 * AttrDao
 */
public interface AttrDao {

    /**
     * 查询全部 Attr
     */
    List<Attr> find(final AttrQuery query);

    /**
     * 通过id得到一个 Attr
     */
    Attr get(final String id);
    
    /**
     * 根据文章id获取 Attr
     */
    List<Attr> findByInfoId(final String id);
    
    /**
     * 通过code得到一个 Attr
     */
    Attr getByCode(final String codeNum);

    /**
     * 新增 Attr
     */
    void add(final AttrForm form);

    /**
     * 修改 Attr
     */
    int update(final AttrForm form);

    /**
     * 根据id删除一个 Attr
     */
    int delete(final String id);
}