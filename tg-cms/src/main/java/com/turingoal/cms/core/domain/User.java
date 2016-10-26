package com.turingoal.cms.core.domain;

import java.io.Serializable;
import org.springframework.security.core.userdetails.UserDetails;
import com.turingoal.common.domain.BaseUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 用户
 */
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseUser implements UserDetails, Serializable {
    private static final long serialVersionUID = 1L;
}