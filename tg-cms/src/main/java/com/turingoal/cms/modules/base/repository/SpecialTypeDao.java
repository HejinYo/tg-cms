package com.turingoal.cms.modules.base.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.turingoal.cms.modules.base.domain.SpecialType;
import com.turingoal.cms.modules.base.domain.form.SpecialTypeForm;
import com.turingoal.cms.modules.base.domain.query.SpecialTypeQuery;

/**
 * 友情链接类型
 */
public interface SpecialTypeDao {

    /**
     * 查询 友情链接类型
     */
    List<SpecialType> find(final SpecialTypeQuery query);

    /**
     * 通过id得到一个 友情链接类型
     */
    SpecialType get(final String id);

    /**
     * 通过名称获取
     */
    SpecialType getByTypeName(final String typeName);

    /**
     * 通过关键字获取
     */
    SpecialType getByMetaKeywords(final String metaKeywords);

    /**
     * 新增 友情链接类型
     */
    void add(final SpecialTypeForm form);

    /**
     * 修改 友情链接类型
     */
    int update(final SpecialTypeForm form);

    /**
     * 根据id删除一个 友情链接类型
     */
    int delete(final String id);

    /**
     * 修改是否可用
     */
    int changeEnabled(@Param("id") final String id, @Param("enabled") final Integer enabled);
}