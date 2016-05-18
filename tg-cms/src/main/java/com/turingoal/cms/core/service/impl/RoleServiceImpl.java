package com.turingoal.cms.core.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.core.commons.TgSecurityURLFilterInvocationSecurityMetadataSource;
import com.turingoal.cms.core.domain.Resource;
import com.turingoal.cms.core.domain.Role;
import com.turingoal.cms.core.domain.form.RoleForm;
import com.turingoal.cms.core.repository.ResourceDao;
import com.turingoal.cms.core.repository.RoleDao;
import com.turingoal.cms.core.repository.RoleResourceDao;
import com.turingoal.cms.core.repository.UserRoleDao;
import com.turingoal.cms.core.service.RoleService;
import com.turingoal.common.annotation.MethodLog;
import com.turingoal.common.bean.BaseZTreeNodeBean;
import com.turingoal.common.constants.ConstantEditableValue;
import com.turingoal.common.constants.ConstantEnabledValue;
import com.turingoal.common.exception.BusinessException;

/**
 * 角色Service
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private ResourceDao resourceDao;
    @Autowired
    private RoleResourceDao roleResourceDao;
    @Autowired
    private TgSecurityURLFilterInvocationSecurityMetadataSource securityMetadataSource;

    /**
     * 查询全部角色
     */
    @MethodLog(name = "查询全部角色", description = "查询全部的角色，不分页")
    public List<Role> findAll() {
        return roleDao.find();
    }

    /**
     * 查询全部启用的角色
     */
    @MethodLog(name = "查询全部启用的角色", description = "查询全部启用的角色，不分页")
    public List<Role> findRoleEnabled() {
        return roleDao.findEnabled();
    }

    /**
     * 查询未使用的角色
     */
    @MethodLog(name = "查询未使用的角色", description = "查询未使用的角色，不分页")
    public List<Role> findRolesUnUse(final String userId) {
        List<Role> selectRoles = userRoleDao.findByUser(userId);
        List<Role> allRoles = roleDao.findEnabled();
        List<Role> roles = new ArrayList<Role>();
        for (Role role : allRoles) {
            if (!(selectRoles.contains(role))) {
                roles.add(role);
            }
        }
        return roles;
    }

    /**
     * 查询指定角色下的所有权限封装成check树
     */
    @MethodLog(name = "查询指定角色下的所有权限", description = "查询指定角色下的所有权限封装成check树")
    public List<BaseZTreeNodeBean> getResourceNameTreeByRole(final String roleId) {
        List<Resource> allEnabledResources;
        List<String> roleAuthIds;
        allEnabledResources = resourceDao.findEnabled();
        roleAuthIds = roleResourceDao.findResourceIdsByRole(roleId);
        List<BaseZTreeNodeBean> nodeList = new ArrayList<BaseZTreeNodeBean>();
        Resource resource;
        for (int i = 0, length = allEnabledResources.size(); i < length; i++) {
            resource = allEnabledResources.get(i);
            BaseZTreeNodeBean node = new BaseZTreeNodeBean();
            node.setId(resource.getId());
            node.setName(resource.getText());
            node.setPId(resource.getParentId());
            node.setOpen(true);
            if (roleAuthIds.contains(resource.getId())) {
                node.setChecked(true);
            }
            nodeList.add(node);
        }
        // Resource root = new Resource();
        // root.setId("0");
        // root.setText("权限");
        // root.setLeaf(false);
        // return TreeBean.createTree(root, nodeList, "nodes");
        return nodeList;

    }

    /**
     * 更新某个角色下的权限
     */
    public boolean updateResourcesByRole(final String roleId, final String resourceIds) throws BusinessException {
        if (roleDao.checkEditable(roleId) != ConstantEditableValue.EDITABLE_INT) {
            throw new BusinessException("GE1000");
        } else {
            roleResourceDao.deleteRoleResourcesByRoleId(roleId);
            String[] idStrings = resourceIds.split(",");
            for (int i = 0; i < idStrings.length; i++) {
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("roleId", roleId);
                params.put("resourceId", idStrings[i]);
                params.put("id", UUID.randomUUID().toString());
                roleResourceDao.addRoleResourcesByRole(params);
            }
            // // 角色拥有权限id
            // List<String> roleResourceIds;
            // roleResourceIds = roleResourceDao.getResourceIdsByRole(query.getId());
            // // 添加原来未选中的 删除没有选中的
            // String[] idsArray = {};
            // Map<String, Object> params = new HashMap<String, Object>();
            // if (!StringUtil.isNullOrBlank(query.getResourceId())) {
            // idsArray = query.getResourceId().split(",");
            // }
            // for (int i = 0, length = idsArray.length; i < length; i++) {
            // String resourceId = idsArray[i];
            // params.put("roleId", query.getId());
            // params.put("resourceId", resourceId);
            // if (!roleResourceIds.contains(resourceId)) {
            // params.put("id", UUID.randomUUID().toString());
            // roleResourceDao.addRoleResourcesByRole(params);
            // } else {
            // roleResourceIds.remove(resourceId);
            // }
            // }
            // if (roleResourceIds.size() > 0) {
            // params = new HashMap<String, Object>();
            // params.put("roleId", query.getId());
            // params.put("resourceIds", roleResourceIds);
            // roleResourceDao.deleteRoleResourcesByRole(params);
            // }
            // 刷新spring security缓存中的Attributes
            securityMetadataSource.freshAllConfigAttributes();
            return true;
        }
    }

    /**
     * 根据id得到一个 角色
     */
    @MethodLog(name = "查询角色", description = "根据id得到一个角色")
    public Role get(final String id) {
        return roleDao.get(id);
    }

    /**
     * 新增 Role
     */
    @MethodLog(name = "新增角色", description = "新增一个角色")
    public void add(final RoleForm form) {
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        roleDao.add(form);
    }

    /**
     * 修改 Role
     */
    @MethodLog(name = "修改Role", description = "修改Role")
    public void update(final RoleForm form) throws BusinessException {
        if (roleDao.checkEditable(form.getId()) != ConstantEditableValue.EDITABLE_INT) {
            throw new BusinessException("GE1000");
        } else {
            form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
            roleDao.update(form);
            // 刷新spring security缓存中的Attributes
            securityMetadataSource.freshAllConfigAttributes();
        }
    }

    /**
     * 根据id删除一个 Role
     */
    @MethodLog(name = "删除Role", description = "根据id删除一个 Role")
    public void delete(final String id) throws BusinessException {
        if (roleDao.checkEditable(id) != ConstantEditableValue.EDITABLE_INT) {
            throw new BusinessException("GE1000");
        } else {
            roleDao.delete(id);
            // 刷新spring security缓存中的Attributes
            securityMetadataSource.freshAllConfigAttributes();
        }
    }

    /**
     * 启用
     */
    @MethodLog(name = "启用Role", description = "根据id启用一个Role")
    public void enable(final String id) throws BusinessException {
        if (roleDao.checkEditable(id) != ConstantEditableValue.EDITABLE_INT) {
            throw new BusinessException("GE1000");
        } else {
            roleDao.changeEnabled(id, ConstantEnabledValue.ENABLED_INT);
            // 刷新spring security缓存中的Attributes
            securityMetadataSource.freshAllConfigAttributes();
        }
    }

    /**
     * 停用
     */
    @MethodLog(name = "停用Role", description = "根据id停用一个Role")
    public void disable(final String id) throws BusinessException {
        if (roleDao.checkEditable(id) != ConstantEditableValue.EDITABLE_INT) {
            throw new BusinessException("GE1000");
        } else {
            roleDao.changeEnabled(id, ConstantEnabledValue.DISABLED_INT);
            // 刷新spring security缓存中的Attributes
            securityMetadataSource.freshAllConfigAttributes();
        }
    }
}