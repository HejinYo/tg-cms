package com.turingoal.cms.core.repository;

import java.util.List;
import java.util.Map;

/**
 * RoleResourceDao
 */
public interface RoleResourceDao {
    /**
     * 查询所有url和对应的role
     */
    List<Map<String, String>> findResourcesWithRole();

    /**
     * 通过用角色id获得资源id集合
     */
    List<String> getResourceIdsByRole(String roleId);

    /**
     * 删除某个角色下部分权限
     */
    int deleteRoleResourcesByRole(Map<String, Object> params);

    /**
     * 删除某个角色下部分权限
     */
    int deleteRoleResourcesByRoleId(String roleId);

    /**
     * 为某个角色新增资源 同时插入多条数据
     */
    void addRoleResourcesByRole(Map<String, Object> params);
}
