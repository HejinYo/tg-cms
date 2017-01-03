package com.turingoal.cms.modules.ext.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.turingoal.cms.modules.ext.domain.GuestbookType;
import com.turingoal.cms.modules.ext.domain.form.GuestbookTypeForm;
import com.turingoal.cms.modules.ext.domain.query.GuestbookTypeQuery;

/**
 * 留言板类型Dao
 */
public interface GuestbookTypeDao {

    /**
     * 查询 留言板类型
     */
    List<GuestbookType> find(final GuestbookTypeQuery query);

    /**
     * 通过id得到一个 留言板类型
     */
    GuestbookType get(final String id);

    /**
     * 通过名称等到一个留言板类型
     */
    GuestbookType getByTypeName(final String typeName);

    /**
     * 通过编码的得到一个留言板类型
     */
    GuestbookType getByCodeNum(final String codeNum);
    
    /**
     * 新增 留言板类型
     */
    void add(final GuestbookTypeForm form);

    /**
     * 修改 留言板类型
     */
    int update(final GuestbookTypeForm form);

    /**
     * 根据id删除一个 留言板类型
     */
    int delete(final String id);

    /**
     * 修改是否可用
     */
    int changeEnabled(@Param("id") final String id, @Param("enabled") final Integer enabled);
}