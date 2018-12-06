package com.luv2code.springsecurity.demo.service;

import com.luv2code.springsecurity.demo.dao.UserDao;
import com.luv2code.springsecurity.demo.entity.Role;
import com.luv2code.springsecurity.demo.entity.User;
import com.luv2code.springsecurity.demo.user.CrmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Arrays;

/**
 * Created by admin on 06.12.2018.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    BCryptPasswordEncoder encoder;
    @Transactional
    @Override
    public User findByUserName(String userName) {
        return userDao.findUser(userName);
    }
    @Transactional
    @Override
    public void save(CrmUser theUser) {
        User user = new User();
        user.setUserName(theUser.getUser());
        user.setPassword(encoder.encode(theUser.getPassword()));
        user.setUserName(theUser.getName());
        user.setLastName(theUser.getLastName());
        user.setEmail(theUser.getEmail());

        // give user default role of "employee"
        user.setRoles(Arrays.asList(new Role("ROLE_EMPLOYEE")));

        // save user in the database
        userDao.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
