package com.luv2code.springsecurity.demo.service;

import com.luv2code.springsecurity.demo.entity.User;
import com.luv2code.springsecurity.demo.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by admin on 06.12.2018.
 */
public interface UserService extends UserDetailsService {
    User findByUserName(String userName);
    void save(CrmUser theUser);
}
