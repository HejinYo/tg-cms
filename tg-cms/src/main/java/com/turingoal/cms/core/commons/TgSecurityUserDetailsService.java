package com.turingoal.cms.core.commons;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.turingoal.cms.core.domain.Role;
import com.turingoal.cms.core.domain.User;
import com.turingoal.cms.core.repository.ResourceDao;
import com.turingoal.cms.core.repository.UserDao;
import com.turingoal.cms.core.repository.UserRoleDao;

/**
 * 用户Service
 */
public class TgSecurityUserDetailsService implements UserDetailsService {
    private final Logger log = LogManager.getLogger(TgSecurityUserDetailsService.class);
    @Autowired
    private UserCache userCache;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private ResourceDao resourceDao;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        // 从缓存中查找用户，如果找到用户就直接用缓存中的用户，如果没有找到就从数据库中获取用户信息。
        User user = (User) this.userCache.getUserFromCache(username.trim());
        if (user == null) {
            user = userDao.getByUsername(username.trim());
            if (user == null) {
                log.info("用户不存在");
                throw new UsernameNotFoundException("用户不存在");
            }
            // 得到用户的权限
            auths = loadUserAuthorities(user.getId());
            user.setAuthorities(auths);
            // 得到用户的permission
            List<String> permissions = resourceDao.findPermissionsByUser(user.getId());
            user.setUserPermissions(permissions);
            userCache.putUserInCache(user); // 放进缓存
        }
        return user;
    }

    /**
     * 根据用户名获取到用户的角色并封装成GrantedAuthority集合
     */
    public Collection<GrantedAuthority> loadUserAuthorities(final String userId) {
        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        List<Role> list = userRoleDao.findByUser(userId);
        GrantedAuthority grantedAuthority;
        if (list != null && list.size() > 0) {
            for (Role role : list) {
                grantedAuthority = new SimpleGrantedAuthority(role.getCodeNum());
                auths.add(grantedAuthority);
            }
        }
        return auths;
    }
}