package com.turingoal.cms.core.repository;

import java.util.List;
import com.turingoal.cms.core.domain.Role;
import com.turingoal.cms.core.domain.form.UserRoleForm;

/**
 * UserRoleDao
 */
public interface UserRoleDao {
    /**
     * 查询用户拥有的角色
     */
    List<Role> findByUser(String userId);

    /**
     * 通过用户id获得角色id集合
     */
    List<String> getRoleIdsByUser(String userId);

    /**
     * 根据userId删除roles
     */
    int deleteByUserId(String userId);

    /**
     * 为某个用户新增角色 同时插入多条数据
     */
    void addUserRole(UserRoleForm form);
}
