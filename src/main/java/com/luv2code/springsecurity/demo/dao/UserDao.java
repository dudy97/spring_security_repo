package com.luv2code.springsecurity.demo.dao;

import com.luv2code.springsecurity.demo.entity.User;

/**
 * Created by admin on 06.12.2018.
 */
public interface UserDao {

    User findUser(String userName);

    void save(User user);
}
