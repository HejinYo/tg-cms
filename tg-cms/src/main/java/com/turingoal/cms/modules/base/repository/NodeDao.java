package com.turingoal.cms.modules.base.repository;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.turingoal.cms.modules.base.domain.Node;
import com.turingoal.cms.modules.base.domain.form.NodeForm;
import com.turingoal.cms.modules.base.domain.query.NodeQuery;

/**
 * 栏目Dao
 */
public interface NodeDao {
    /**
     * 根据父栏目编码查询栏目
     */
    List<Node> findByParentCodeNum(@Param("parentCodeNum") final String parentCodeNum, @Param("limit") final Long limit);

    /**
     * 查询 栏目
     */
    List<Node> find(final NodeQuery query);

    /**
     * 通过id得到一个 栏目
     */
    Node get(final String id);

    /**
     * 通过栏目名称获取
     */
    Node getByNoddName(final String noddName);

    /**
     * 通过codeNum得到一个栏目
     */
    Node getByCode(final NodeQuery query);

    /**
     * 新增 栏目
     */
    void add(final NodeForm form);

    /**
     * 修改 栏目
     */
    int update(final NodeForm form);

    /**
     * 根据id删除一个 栏目
     */
    int delete(final String id);

    /**
     * 修改状态
     */
    int changeState(final Map<String, Object> map);
}