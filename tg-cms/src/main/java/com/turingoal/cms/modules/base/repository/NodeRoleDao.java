package com.turingoal.cms.modules.base.repository;

import java.util.List;
import java.util.Map;
import com.turingoal.cms.modules.base.domain.NodeRole;
import com.turingoal.cms.modules.base.domain.form.NodeRoleForm;
import com.turingoal.cms.modules.base.domain.query.NodeRoleQuery;

/**
 * NodeRoleDao 
 */
public interface NodeRoleDao {
    
    /**
     * 查询 NodeRole
     */
    List<NodeRole> find(final NodeRoleQuery query);
    
    /**
     * 通过id得到一个 NodeRole
     */
    NodeRole get(final String id);
    
    /**
     * 新增 NodeRole
     */
    void add(final NodeRoleForm form);

    /**
     * 修改 NodeRole
     */
    int update(final NodeRoleForm form);
    
    /**
     * 根据id删除一个 NodeRole
     */
    int delete(final String id);
    
    /**
     * 修改状态
     */
    int changeState(final Map<String, Object> map);
}