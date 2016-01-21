package com.turingoal.cms.core.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.turingoal.cms.core.domain.Role;
import com.turingoal.cms.core.domain.form.RoleForm;

/**
 * 角色Dao
 */
public interface RoleDao {

    /**
     * 查询全部角色
     */
    List<Role> find();

    /**
     * 查询全部启用的角色
     */
    List<Role> findEnabled();

    /**
     * 通过id得到一个角色
     */
    Role get(final String id);

    /**
     * 新增角色
     */
    void add(final RoleForm form);

    /**
     * 修改角色
     */
    int update(final RoleForm form);

    /**
     * 根据id删除一个角色
     */
    int delete(final String id);

    /**
     * 根据id删除多个角色
     */
    int deleteAll(final String ids);

    /**
     * 修改是否可用
     */
    int changeEnabled(@Param("id") final String id, @Param("enabled") final Integer enabled);

    /**
     * 检测数据是否可编辑
     */
    int checkEditable(final String id);
}