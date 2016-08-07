package com.turingoal.cms.core.commons;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import com.turingoal.cms.core.repository.RoleResourceDao;
import jodd.util.StringUtil;

/**
 * 通过数据库管理url
 */
public class TgSecurityURLFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource, InitializingBean {
	private final Logger log = LogManager.getLogger(TgSecurityURLFilterInvocationSecurityMetadataSource.class);
	private static final List<ConfigAttribute> NULL_CONFIG_ATTRIBUTE = Collections.emptyList(); // 权限集合
	private Map<String, Collection<ConfigAttribute>> requestMap;
	private Collection<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();
	private Map<String, String> interceptUrlsMap; // 从xml获取的interceptUrl

	public void setInterceptUrlsMap(final Map<String, String> interceptUrlsMapParm) {
		this.interceptUrlsMap = interceptUrlsMapParm;
	}

	@Autowired
	private RoleResourceDao roleResourceDao;

	/**
	 * 获取所有权限集合
	 */
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return allAttributes;
	}

	/**
	 * 根据request请求获取访问资源所需权限
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(final Object paramObject) throws IllegalArgumentException {
		final HttpServletRequest request = ((FilterInvocation) paramObject).getRequest();
		Collection<ConfigAttribute> attrs = NULL_CONFIG_ATTRIBUTE;
		for (Map.Entry<String, Collection<ConfigAttribute>> entry : requestMap.entrySet()) {
			if (new AntPathRequestMatcher(entry.getKey()).matches(request)) {
				attrs = entry.getValue();
				break;
			}
		}
		log.debug("URL：" + request.getRequestURI() + " -> " + attrs);
		return attrs;
	}

	@Override
	public boolean supports(final Class<?> paramClass) {
		return FilterInvocation.class.isAssignableFrom(paramClass);
	}

	/**
	 * bindRequestMap需要在类初始化的时候就完成，但是这个不能写在构造函数中，因为构造函数执行是resourceDao还没有注入过来。所以就通过实现InitializingBean把初始化操作放在afterPropertiesSet方法中
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		requestMap = bindRequestMap();
		log.debug("资源权限列表" + requestMap);
	}

	/**
	 * 将权限map转换成 ConfigAttribute 从数据库获得权限封装成：url：role1,role2 这种形式
	 */
	protected Map<String, Collection<ConfigAttribute>> bindRequestMap() {
		Map<String, Collection<ConfigAttribute>> map = new LinkedHashMap<String, Collection<ConfigAttribute>>();
		// 封装从数据库获取的 url和对应的role
		List<Map<String, String>> allUrlsWithRoles = roleResourceDao.findResourcesWithRole();
		if (allUrlsWithRoles != null && allUrlsWithRoles.size() > 0) {
			Collection<ConfigAttribute> atts = null;
			for (Map<String, String> urlWithRole : allUrlsWithRoles) {
				String authUrl = urlWithRole.get("auth_url");
				String roleCode = urlWithRole.get("role_code");
				// url 不能为空
				if (StringUtil.isNotBlank(authUrl)) {
					if (map.containsKey(authUrl)) {
						atts = map.get(authUrl);
						atts.add(new SecurityConfig(roleCode));
					} else {
						atts = new HashSet<ConfigAttribute>(SecurityConfig.createListFromCommaDelimitedString(roleCode));
						map.put(authUrl, atts);
					}
					// 所有权限集合
					allAttributes.add(new SecurityConfig(roleCode));
				}
			}
		}
		// 封装从xml获得的interceptUrls，顺序很重要，spring security按顺序获得第一个匹配的url，通过放行不继续匹配，不通过结束
		if (interceptUrlsMap != null && interceptUrlsMap.size() > 0) {
			Collection<ConfigAttribute> atts1 = null;
			Collection<ConfigAttribute> attSet = null;
			for (Map.Entry<String, String> entry : interceptUrlsMap.entrySet()) {
				String authUrl = entry.getKey();
				attSet = new HashSet<ConfigAttribute>(SecurityConfig.createListFromCommaDelimitedString(entry.getValue()));
				if (map.containsKey(authUrl)) {
					atts1 = map.get(authUrl);
					atts1.addAll(attSet);
				} else {
					map.put(authUrl, attSet);
				}
				// 所有权限集合
				allAttributes.addAll(attSet);
			}
		}
		return map;
	}

	/**
	 * 刷新缓存
	 */
	public void freshAllConfigAttributes() {
		getAllConfigAttributes();
	}
}
