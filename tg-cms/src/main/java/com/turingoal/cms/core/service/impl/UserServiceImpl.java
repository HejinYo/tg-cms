package com.turingoal.cms.core.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.core.commons.TgSecurityPasswordHelper;
import com.turingoal.cms.core.domain.Role;
import com.turingoal.cms.core.domain.User;
import com.turingoal.cms.core.domain.form.UserForm;
import com.turingoal.cms.core.domain.form.UserRoleForm;
import com.turingoal.cms.core.domain.query.UserQuery;
import com.turingoal.cms.core.repository.UserDao;
import com.turingoal.cms.core.repository.UserRoleDao;
import com.turingoal.cms.core.service.UserService;
import com.turingoal.common.annotation.MethodLog;
import com.turingoal.common.constants.ConstantEnabledValue;
import com.turingoal.common.constants.ConstantEditableValue;
import com.turingoal.common.constants.ConstantSystemValues;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.exception.ExceptionCode;
import com.turingoal.common.util.lang.StringUtil;

/**
 * 用户Service
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRoleDao userRoleDao;

    /**
     * 检查用户密码
     */
    @MethodLog(name = "检查用户密码", description = "检查用户密码")
    public boolean checkUserPass(final String id, final String userPass) {
        return TgSecurityPasswordHelper.isPasswordValid(userDao.get(id).getUserPass(), userPass);
    }

    /**
     * 修改密码
     */
    @MethodLog(name = "修改用户密码", description = "修改用户密码")
    public int updateCurrentUserPass(final String userPass) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", SystemHelper.getCurrentUserId());
        params.put("userPass", TgSecurityPasswordHelper.encodePassword(userPass)); // 密码加密
        return userDao.updateUserPass(params);
    }

    /**
     * 重置用户密码
     */
    @MethodLog(name = "重置用户密码", description = "重置用户密码")
    public int resetUserPass(final String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("userPass", TgSecurityPasswordHelper.encodePassword(ConstantSystemValues.INIT_PASS)); // 密码加密
        return userDao.updateUserPass(params);
    }

    /**
     * 通过用户名得到用户的id 及登录信息
     */
    @MethodLog(name = "通过用户名得到用户的id及登录信息", description = "通过用户名得到用户的id及登录信息")
    public User getLoginInfoByUsername(final String username) {
        return userDao.getByUsername(username);
    }

    /**
     * 分页查询 User
     */
    @MethodLog(name = "分页查询 User", description = "分页查询 User")
    public Page<User> findByPage(final UserQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        return (Page<User>) userDao.find(query);
    }

    /**
     * 查询某个用户下的角色id
     */
    @MethodLog(name = "查询某个用户下的角色id", description = "查询某个用户下的角色id")
    public List<String> getRoleIdsByUser(final String userId) {
        return userRoleDao.getRoleIdsByUser(userId);
    }

    /**
     * 查询某个用户下的所有角色信息
     */
    @MethodLog(name = "查询某个用户下的所有角色信息", description = "查询某个用户下的所有角色信息")
    public List<Role> getRolesByUser(final String userId) {
        return userRoleDao.findByUser(userId);
    }

    /**
     * 更新某个用户下的角色
     */
    public boolean updateRolesByUser(final String userId, final String roleIds) throws BusinessException {
        if (userDao.checkEditable(userId) != ConstantEditableValue.EDITABLE_INT) {
            throw new BusinessException(ExceptionCode.CODE_1000);
        } else {
            userRoleDao.deleteByUserId(userId);
            String[] roleIdArray = roleIds.split(",");
            for (String roleId : roleIdArray) {
                UserRoleForm urForm = new UserRoleForm();
                urForm.setUserId(userId);
                urForm.setRoleId(roleId);
                urForm.setCreateDataUsername(SystemHelper.getCurrentUsername());
                userRoleDao.addUserRole(urForm);
            }
            return true;
        }
    }

    /**
     * 通过id得到一个 User
     */
    @MethodLog(name = "得到一个User", description = "通过id得到一个 User")
    public User get(final String id) {
        return userDao.get(id);
    }

    /**
     * 新增 User
     */
    @MethodLog(name = "新增User", description = "新增一个User")
    public void add(final UserForm form) {
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        String userPass = form.getUserPass();
        if (StringUtil.isNullOrBlank(userPass)) {
            userPass = ConstantSystemValues.INIT_PASS; // 系统默认密码
        }
        form.setUserPass(TgSecurityPasswordHelper.encodePassword(userPass)); // 密码加密
        userDao.add(form);
    }

    /**
     * 修改 User
     */
    @MethodLog(name = "修改User", description = "修改User")
    public int update(final UserForm form) throws BusinessException {
        if (userDao.checkEditable(form.getId()) != ConstantEditableValue.EDITABLE_INT) {
            throw new BusinessException(ExceptionCode.CODE_1000);
        } else {
            form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
            return userDao.update(form);
        }
    }

    /**
     * 修改当前 User
     */
    @MethodLog(name = "修改当前User", description = "修改当前User")
    public int updateCurrentUser(final UserForm form) throws BusinessException {
        if (userDao.checkEditable(SystemHelper.getCurrentUserId()) != ConstantEditableValue.EDITABLE_INT) {
            throw new BusinessException(ExceptionCode.CODE_1000);
        } else {
            return userDao.updateCurrentUser(form);
        }
    }

    /**
     * 根据id删除一个 User
     */
    @MethodLog(name = "删除User", description = " 根据id删除一个 User")
    public int delete(final String id) throws BusinessException {
        if (userDao.checkEditable(id) != ConstantEditableValue.EDITABLE_INT) {
            throw new BusinessException(ExceptionCode.CODE_1000);
        } else {
            return userDao.delete(id);
        }
    }

    /**
     * 启用
     */
    @MethodLog(name = "启用User", description = " 根据id启用一个User")
    public int enable(final String id) throws BusinessException {
        if (userDao.checkEditable(id) != ConstantEditableValue.EDITABLE_INT) {
            throw new BusinessException(ExceptionCode.CODE_1000);
        } else {
            return userDao.changeEnabled(id, ConstantEnabledValue.ENABLED_INT);
        }
    }

    /**
     * 停用
     */
    @MethodLog(name = "停用User", description = " 根据id停用一个User")
    public int disable(final String id) throws BusinessException {
        if (userDao.checkEditable(id) != ConstantEditableValue.EDITABLE_INT) {
            throw new BusinessException(ExceptionCode.CODE_1000);
        } else {
            return userDao.changeEnabled(id, ConstantEnabledValue.DISABLED_INT);
        }
    }
}