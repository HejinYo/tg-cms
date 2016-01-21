package com.turingoal.cms.modules.base.repository;

import java.util.List;
import java.util.Map;
import com.turingoal.cms.modules.base.domain.NodeGroup;
import com.turingoal.cms.modules.base.domain.form.NodeGroupForm;
import com.turingoal.cms.modules.base.domain.query.NodeGroupQuery;

/**
 * NodeGroupDao 
 */
public interface NodeGroupDao {
    
    /**
     * 查询 NodeGroup
     */
    List<NodeGroup> find(final NodeGroupQuery query);

    /**
     * 通过id得到一个 NodeGroup
     */
    NodeGroup get(final String id);
    
    /**
     * 新增 NodeGroup
     */
    void add(final NodeGroupForm form);

    /**
     * 修改 NodeGroup
     */
    int update(final NodeGroupForm form);
    
    /**
     * 根据id删除一个 NodeGroup
     */
    int delete(final String id);
    
    /**
     * 修改状态
     */
    int changeState(final Map<String, Object> map);
}