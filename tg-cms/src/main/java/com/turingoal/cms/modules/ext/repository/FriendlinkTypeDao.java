package com.turingoal.cms.modules.ext.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.turingoal.cms.modules.ext.domain.FriendlinkType;
import com.turingoal.cms.modules.ext.domain.form.FriendlinkTypeForm;
import com.turingoal.cms.modules.ext.domain.query.FriendlinkTypeQuery;

/**
 * 友情链接类型Dao
 */
public interface FriendlinkTypeDao {

    /**
     * 查询 友情链接类型
     */
    List<FriendlinkType> find(final FriendlinkTypeQuery query);

    /**
     * 通过id得到一个 友情链接类型
     */
    FriendlinkType get(final String id);

    /**
     * 新增 友情链接类型
     */
    void add(final FriendlinkTypeForm form);

    /**
     * 修改 友情链接类型
     */
    int update(final FriendlinkTypeForm form);

    /**
     * 根据id删除一个 友情链接类型
     */
    int delete(final String id);

    /**
     * 修改是否可用
     */
    int changeEnabled(@Param("id") final String id, @Param("enabled") final Integer enabled);
}