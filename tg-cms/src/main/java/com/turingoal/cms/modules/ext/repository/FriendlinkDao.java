package com.turingoal.cms.modules.ext.repository;

import java.util.List;
import java.util.Map;
import com.turingoal.cms.modules.ext.domain.Friendlink;
import com.turingoal.cms.modules.ext.domain.form.FriendlinkForm;
import com.turingoal.cms.modules.ext.domain.query.FriendlinkQuery;

/**
 * 友情链接Dao
 */
public interface FriendlinkDao {

    /**
     * 查询 友情链接
     */
    List<Friendlink> find(final FriendlinkQuery query);

    /**
     * 查询 友情链接
     */
    List<Friendlink> findEnabled(final FriendlinkQuery query);

    /**
     * 通过id得到一个 友情链接
     */
    Friendlink get(final String id);

    /**
     * 新增 友情链接
     */
    void add(final FriendlinkForm form);

    /**
     * 修改 友情链接
     */
    int update(final FriendlinkForm form);

    /**
     * 根据id删除一个 友情链接
     */
    int delete(final String id);

    /**
     * 修改友情链接状态
     */
    int changeState(final Map<String, Object> map);

    /**
     * 根据id更改友情链接推荐状态
     */
    int changeRecommend(final FriendlinkForm form);
}