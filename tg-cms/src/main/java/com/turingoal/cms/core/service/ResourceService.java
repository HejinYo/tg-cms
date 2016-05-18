package com.turingoal.cms.core.service;

import java.util.List;
import com.turingoal.cms.core.domain.Resource;
import com.turingoal.cms.core.domain.form.ResourceForm;
import com.turingoal.common.bean.BaseTreeNodeBean;
import com.turingoal.common.exception.BusinessException;

/**
 * ResourceService
 */
public interface ResourceService {

    /**
     * 根据用户id获取一级菜单
     */
    List<Resource> findFirstLevelMenusEnabledByUserId(final String userId);

    /**
     * 获取用户子菜单 查询所有子节点 不是当前的 不然只显示一级
     */
    BaseTreeNodeBean findChildrenMenusEnabledTreeByUserId(final String userId, final String parentId);

    /**
     * 获取用户菜单树
     */
    BaseTreeNodeBean findMenusEnabledTreeByUserId(final String userId);

    /**
     * 查询全部 Resource的树
     */
    BaseTreeNodeBean getResourceTreeGird();

    /**
     * 查询角色资源树
     */
    BaseTreeNodeBean getResourceTreeByRole(final String id);

    /**
     * 查询全部 启用的Resource名称树
     */
    BaseTreeNodeBean getResourceEnabledTree();

    /**
     * 根据id获取资源信息
     */
    Resource get(final String id);

    /**
     * 新增 Resource
     */
    void add(final ResourceForm form);

    /**
     * 修改 Resource
     */
    void update(final ResourceForm form) throws BusinessException;

    /**
     * 根据id删除一个 Resource
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

    /**
     * 获取username的所有权限
     */
    List<String> findPermissionsEnabledByUser(final String username);

    /**
     * 获取所有权限
     */
    List<Resource> findAll();
}