package com.turingoal.cms.modules.base.repository;

import java.util.List;
import com.turingoal.cms.modules.base.domain.Tag;
import com.turingoal.cms.modules.base.domain.form.TagForm;
import com.turingoal.cms.modules.base.domain.query.TagQuery;

/**
 * TagDao
 */
public interface TagDao {

    /**
     * 查询 Tag
     */
    List<Tag> find(final TagQuery query);

    /**
     * 通过id得到一个 Tag
     */
    Tag get(final String id);

    /**
     * 通过name得到一个 Tag
     */
    Tag findByName(final String name);

    /**
     * 根据infoId获取 Tag
     */
    List<Tag> findByInfoId(final String infoId);

    /**
     * 新增 Tag
     */
    void add(final TagForm form);

    /**
     * 修改 Tag
     */
    int update(final TagForm form);

    /**
     * 修改 Tag引用次数(减1)
     */
    int updateRefersSubtract(final String id);

    /**
     * 修改 Tag引用次数(加1)
     */
    int updateRefersAdd(final String id);

    /**
     * 根据id删除一个 Tag
     */
    int delete(final String id);

    /**
     * 新增文章、标签关系
     */
    void addRelation(final TagForm form);

    /**
     * 删除文章、标签关系
     */
    int deleteRelation(final String id);

    /**
     * 删除文章、标签关系
     */
    int deleteRelationByInfoId(final String infoId);
}