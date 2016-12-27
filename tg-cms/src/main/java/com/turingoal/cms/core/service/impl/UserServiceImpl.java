package com.turingoal.cms.core.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.core.domain.User;
import com.turingoal.cms.core.domain.form.UserForm;
import com.turingoal.cms.core.repository.UserDao;
import com.turingoal.cms.core.service.UserService;
import com.turingoal.common.annotation.MethodLog;
import com.turingoal.common.constants.ConstantEditableValue;
import com.turingoal.common.constants.ConstantEnabledValue;
import com.turingoal.common.constants.ConstantSystemValues;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.util.lang.StringUtil;
import com.turingoal.common.util.spring.SpringSecurityPasswordUtil;

/**
 * 用户Service
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 检查用户密码
     */
    @MethodLog(name = "检查用户密码", description = "检查用户密码")
    public boolean checkUserPass(final String id, final String userPass) {
        return SpringSecurityPasswordUtil.isPasswordValid(userDao.get(id).getUserPass(), userPass);
    }

    /**
     * 修改密码
     */
    @MethodLog(name = "修改用户密码", description = "修改用户密码")
    public int updateCurrentUserPass(final String userPass) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", SystemHelper.getCurrentUserId());
        params.put("userPass", SpringSecurityPasswordUtil.encodePassword(userPass)); // 密码加密
        return userDao.updateUserPass(params);
    }

    /**
     * 重置用户密码
     */
    @MethodLog(name = "重置用户密码", description = "重置用户密码")
    public int resetUserPass(final String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("userPass", SpringSecurityPasswordUtil.encodePassword(ConstantSystemValues.INIT_PASS)); // 密码加密
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
     * 查询 User
     */
    @MethodLog(name = "查询 User", description = "查询 User")
    public List<User> findAll() {
        return userDao.find();
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
        form.setDomain("admin");
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        String userPass = form.getUserPass();
        if (StringUtil.isNullOrBlank(userPass)) {
            userPass = ConstantSystemValues.INIT_PASS; // 系统默认密码
        }
        form.setUserPass(SpringSecurityPasswordUtil.encodePassword(userPass)); // 密码加密
        userDao.add(form);
    }

    /**
     * 修改 User
     */
    @MethodLog(name = "修改User", description = "修改User")
    public int update(final UserForm form) throws BusinessException {
        if (userDao.checkEditable(form.getId()) != ConstantEditableValue.EDITABLE_INT) {
            throw new BusinessException("GE1000");
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
            throw new BusinessException("GE1000");
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
            throw new BusinessException("GE1000");
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
            throw new BusinessException("GE1000");
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
            throw new BusinessException("GE1000");
        } else {
            return userDao.changeEnabled(id, ConstantEnabledValue.DISABLED_INT);
        }
    }
}