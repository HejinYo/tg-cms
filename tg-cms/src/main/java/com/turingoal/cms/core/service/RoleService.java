package com.turingoal.cms.core.service;

import java.util.List;
import com.turingoal.cms.core.domain.Role;
import com.turingoal.cms.core.domain.form.RoleForm;
import com.turingoal.common.bean.BaseZTreeNodeBean;
import com.turingoal.common.exception.BusinessException;

/**
 * 角色Service
 */
public interface RoleService {

    /**
     * 查询全部 Role
     */
    List<Role> findAll();

    /**
     * 查询全部启用的 Role
     */
    List<Role> findRoleEnabled();

    /**
     * findRolesUnUse
     */
    List<Role> findRolesUnUse(final String userId);

    /**
     * 查询指定角色下的所有权限封装成check树
     */
    List<BaseZTreeNodeBean> getResourceNameTreeByRole(final String roleId);

    /**
     * 更新某个角色下的权限
     */
    boolean updateResourcesByRole(final String roleId, final String resourceIds) throws BusinessException;

    /**
     * 根据id得到一个 角色
     */
    Role get(final String id);

    /**
     * 新增 Role
     */
    void add(final RoleForm form);

    /**
     * 修改 Role
     */
    void update(final RoleForm form) throws BusinessException;

    /**
     * 根据id删除一个 Role
     */
    void delete(final String id) throws BusinessException;

    /**
     * 启用
     */
    void enable(final String id) throws BusinessException;

    /**
     * 停用
     */
    void disable(final String id) throws BusinessException;
}