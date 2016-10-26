package com.turingoal.cms.core.repository;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.turingoal.cms.core.domain.User;
import com.turingoal.cms.core.domain.form.UserForm;

/**
 * UserDao
 */
public interface UserDao {

    /**
     * 修改用户密码
     */
    int updateUserPass(final Map<String, Object> map);

    /**
     * 通过用户名和密码返回一个用户
     */
    User login(final Map<String, Object> map);

    /**
     * 通过Username得到一个 User
     */
    User getByUsername(final String username);

    /**
     * 通过Username得到一个 User的id
     */
    String getIdByUsername(final String username);

    /**
     * 查询 User
     */
    List<User> find();

    /**
     * 通过id得到一个 User
     */
    User get(final String id);

    /**
     * 新增 User
     */
    void add(final UserForm form);

    /**
     * 修改 User
     */
    int update(final UserForm form);

    /**
     * 修改 当前User
     */
    int updateCurrentUser(final UserForm form);

    /**
     * 修改当前User登录信息
     */
    int updateUserLoginInfo(final UserForm form);

    /**
     * 修改User退出信息
     */
    int updateUserLogoutInfo(final UserForm form);

    /**
     * 根据id删除一个 User
     */
    int delete(final String id);

    /**
     * 修改是否可用
     */
    int changeEnabled(@Param("id") final String id, @Param("enabled") final Integer enabled);

    /**
     * 检测数据是否可编辑
     */
    int checkEditable(final String id);
}