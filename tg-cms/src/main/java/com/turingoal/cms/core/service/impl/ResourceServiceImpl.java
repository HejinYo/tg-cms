package com.turingoal.cms.core.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.core.commons.TgSecurityURLFilterInvocationSecurityMetadataSource;
import com.turingoal.cms.core.domain.Resource;
import com.turingoal.cms.core.domain.form.ResourceForm;
import com.turingoal.cms.core.repository.ResourceDao;
import com.turingoal.cms.core.repository.UserDao;
import com.turingoal.cms.core.service.ResourceService;
import com.turingoal.common.annotation.MethodLog;
import com.turingoal.common.bean.BaseTreeNodeBean;
import com.turingoal.common.bean.TreeBean;
import com.turingoal.common.constants.ConstantEditableValue;
import com.turingoal.common.constants.ConstantEnabledValue;
import com.turingoal.common.constants.ConstantSystemValues;
import com.turingoal.common.exception.BusinessException;

/**
 * ResourceService
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private ResourceDao resourceDao;
    @Autowired
    private TgSecurityURLFilterInvocationSecurityMetadataSource securityMetadataSource;

    /**
     * 获取所有启用的菜单
     */
    @Cacheable(value = "sys-resourceCache", key = "'findAllMenusEnabled'")
    @MethodLog(name = "获取所有启用的菜单", description = "获取所有启用的菜单")
    private List<Resource> findAllMenusEnabled() {
        return resourceDao.findAllMenusEnabled();
    }

    /**
     * 获取所有启用的一级菜单
     */
    @Cacheable(value = "sys-resourceCache", key = "'findFirstLevelMenusEnabled'")
    @MethodLog(name = "获取所有启用的一级菜单 ", description = "获取所有启用的一级菜单")
    private List<Resource> findFirstLevelMenusEnabled() {
        return resourceDao.findFirstLevelMenusEnabled();
    }

    /**
     * 获取下面一级子菜单
     */
    @Cacheable(value = "sys-resourceCache", key = "'findFirstLevelMenusEnabled-parentId='+#parentId")
    @MethodLog(name = "获取启用的子菜单 ", description = "获取启用的子菜单")
    private List<Resource> findChildrenMenusEnabled(final String parentId) {
        return resourceDao.findChildrenMenusEnabled(parentId);
    }

    /**
     * 根据id获取资源信息
     */
    @MethodLog(name = "根据id获取资源信息", description = "根据id获取一个资源信息")
    public Resource get(final String id) {
        return resourceDao.get(id);
    }

    /**
     * 根据用户获取启用资源id
     */
    @Cacheable(value = "sys-resourceCache", key = "'findIdsEnabledByUserId-userId='+#userId")
    @MethodLog(name = "根据用户获取启用资源id", description = "根据用户获取启用资源id")
    private List<String> findIdsEnabledByUserId(final String userId) {
        return resourceDao.findIdsEnabledByUserId(userId);
    }

    /**
     * 根据用户id获取一级菜单
     */
    @Cacheable(value = "sys-resourceCache", key = "'findFirstLevelMenusEnabledByUserId-userId'+#userId")
    @MethodLog(name = "获取用户一级菜单 ", description = "根据用户id获取一级菜单")
    public List<Resource> findFirstLevelMenusEnabledByUserId(final String userId) {
        List<Resource> menus = findFirstLevelMenusEnabled();
        // 超级管理员
        if (ConstantSystemValues.ADMIN_USER.equals(userDao.get(userId).getUsername())) {
            return menus;
        } else {
            List<Resource> userMenus = new ArrayList<>();
            List<String> ids = findIdsEnabledByUserId(userId);
            for (int i = 0, length = menus.size(); i < length; i++) {
                Resource menu = menus.get(i);
                if (ids.contains(menu.getId())) {
                    userMenus.add(menu);
                }
            }
            return userMenus;
        }
    }

    /**
     * 获取用户子菜单 查询所有子节点 不是当前的 不然只显示一级
     */
    @Cacheable(value = "sys-resourceCache", key = "'findChildrenMenusEnabledTreeByUserId-userId='+#userId+'-parentId='+#parentId")
    @MethodLog(name = "获取用户子菜单树 ", description = "获取用户子菜单树")
    public BaseTreeNodeBean findChildrenMenusEnabledTreeByUserId(final String userId, final String parentId) {
        List<Resource> menus = findAllMenusEnabled();
        List<Resource> userMenus = new ArrayList<>();
        if (ConstantSystemValues.ADMIN_USER.equals(userDao.get(userId).getUsername())) {
            userMenus = menus;
        } else {
            List<String> ids = findIdsEnabledByUserId(userId);
            for (int i = 0, length = menus.size(); i < length; i++) {
                Resource menu = menus.get(i);
                if (ids.contains(menu.getId())) {
                    userMenus.add(menu);
                }
            }
        }
        List<? extends BaseTreeNodeBean> nodeList = userMenus;
        BaseTreeNodeBean root = new Resource();
        root.setId(parentId);
        root.setLeaf(false);
        return TreeBean.createTree(root, nodeList, null);
    }

    /**
     * 获取用户菜单树
     */
    @Cacheable(value = "sys-resourceCache", key = "'findMenusEnabledTreeByUserId-userId='+#userId")
    @MethodLog(name = "获取用户菜单树 ", description = "获取用户菜单树")
    public BaseTreeNodeBean findMenusEnabledTreeByUserId(final String userId) {
        List<Resource> menus = findAllMenusEnabled();
        List<Resource> userMenus = new ArrayList<>();
        if (ConstantSystemValues.ADMIN_USER.equals(userDao.get(userId).getUsername())) {
            userMenus = menus;
        } else {
            List<String> ids = findIdsEnabledByUserId(userId);
            for (int i = 0, length = menus.size(); i < length; i++) {
                Resource menu = menus.get(i);
                if (ids.contains(menu.getId())) {
                    userMenus.add(menu);
                }
            }
        }
        List<? extends BaseTreeNodeBean> nodeList = userMenus;
        BaseTreeNodeBean root = new Resource();
        root.setId("0");
        root.setLeaf(false);
        return TreeBean.createTree(root, nodeList, null);
    }

    /**
     * 查询全部 Resource的树
     */
    @Cacheable(value = "sys-resourceCache", key = "'getResourceTreeGird'")
    @MethodLog(name = "查询全部 Resource的树", description = "查询全部 Resource的树，不分页")
    public BaseTreeNodeBean getResourceTreeGird() {
        List<Resource> allResources;
        allResources = resourceDao.find();
        List<? extends BaseTreeNodeBean> nodeList = allResources;
        BaseTreeNodeBean root = new Resource();
        root.setId("0");
        root.setLeaf(false);
        return TreeBean.createTree(root, nodeList, "nodes");
    }

    /**
     * 查询角色资源树
     */
    @MethodLog(name = "查询角色资源树", description = "查询角色资源树，不分页")
    public BaseTreeNodeBean getResourceTreeByRole(final String roleId) {
        List<Resource> allResources;
        allResources = resourceDao.findByRole(roleId);
        List<? extends BaseTreeNodeBean> nodeList = allResources;
        BaseTreeNodeBean root = new Resource();
        root.setId("0");
        root.setLeaf(false);
        return TreeBean.createTree(root, nodeList, "nodes");
    }

    /**
     * 查询全部 启用的Resource名称树
     */
    @Cacheable(value = "sys-resourceCache", key = "'getResourceEnabledTree'")
    @MethodLog(name = "查询全部启用的 Resource名称的树", description = "查询全部启用的 Resource名称的树，不分页")
    public BaseTreeNodeBean getResourceEnabledTree() {
        List<Resource> allResources;
        allResources = resourceDao.findEnabled();
        List<? extends BaseTreeNodeBean> nodeList = allResources;
        BaseTreeNodeBean root = new Resource();
        root.setId("0");
        root.setLeaf(false);
        return TreeBean.createTree(root, nodeList, "nodes");
    }

    /**
     * 新增 Resource
     */
    @CacheEvict(value = "sys-resourceCache", allEntries = true)
    @MethodLog(name = "新增Resource", description = "新增一个Resource")
    public void add(final ResourceForm form) {
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        resourceDao.add(form);
        // 刷新spring security缓存中的Attributes
        securityMetadataSource.freshAllConfigAttributes();
    }

    /**
     * 修改 Resource
     */
    @CacheEvict(value = "sys-resourceCache", allEntries = true)
    @MethodLog(name = "修改Resource", description = "修改Resource")
    public void update(final ResourceForm form) throws BusinessException {
        if (resourceDao.checkEditable(form.getId()) != ConstantEditableValue.EDITABLE_INT) {
            throw new BusinessException("GE1000");
        } else {
            form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
            resourceDao.update(form);
            // 刷新spring security缓存中的Attributes
            securityMetadataSource.freshAllConfigAttributes();
        }
    }

    /**
     * 根据id删除一个 Resource
     */
    @CacheEvict(value = "sys-resourceCache", allEntries = true)
    @MethodLog(name = "删除Resource", description = "根据id删除一个 Resource")
    public void delete(final String id) throws BusinessException {
        if (resourceDao.checkEditable(id) != ConstantEditableValue.EDITABLE_INT) {
            throw new BusinessException("GE1000");
        } else {
            resourceDao.delete(id);
            // 刷新spring security缓存中的Attributes
            securityMetadataSource.freshAllConfigAttributes();
        }
    }

    /**
     * 启用
     */
    @CacheEvict(value = "sys-resourceCache", allEntries = true)
    @MethodLog(name = "启用Resource", description = " 根据id启用一个Resource")
    public void enable(final String id) throws BusinessException {
        if (resourceDao.checkEditable(id) != ConstantEditableValue.EDITABLE_INT) {
            throw new BusinessException("GE1000");
        } else {
            resourceDao.changeEnabled(id, ConstantEnabledValue.ENABLED_INT);
            // 刷新spring security缓存中的Attributes
            securityMetadataSource.freshAllConfigAttributes();
        }
    }

    /**
     * 停用
     */
    @CacheEvict(value = "sys-resourceCache", allEntries = true)
    @MethodLog(name = "停用Resource", description = "根据id停用一个Resource")
    public void disable(final String id) throws BusinessException {
        if (resourceDao.checkEditable(id) != ConstantEditableValue.EDITABLE_INT) {
            throw new BusinessException("GE1000");
        } else {
            resourceDao.changeEnabled(id, ConstantEnabledValue.DISABLED_INT);
            // 刷新spring security缓存中的Attributes
            securityMetadataSource.freshAllConfigAttributes();
        }
    }

    @Override
    public List<String> findPermissionsEnabledByUser(final String username) {
        // 判断是否超级管理员
        List<String> auths;
        if ((ConstantSystemValues.ADMIN_USER.equals(username))) {
            auths = resourceDao.findPermissions();
        } else {
            String userId = userDao.getIdByUsername(username);
            auths = resourceDao.findPermissionsByUser(userId);
        }
        return auths;
    }

    @Override
    public List<Resource> findAll() {
        return resourceDao.find();
    }
}