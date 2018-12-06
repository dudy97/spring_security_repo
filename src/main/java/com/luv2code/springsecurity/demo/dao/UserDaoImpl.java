package com.luv2code.springsecurity.demo.dao;

import com.luv2code.springsecurity.demo.entity.User;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

/**
 * Created by admin on 06.12.2018.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory factory;

    @Override
    public User findUser(String theUserName) {
        Session session = factory.getCurrentSession();
        Query<User> theQuery = session.createQuery("from User where userName:=uName", User.class);
        theQuery.setParameter("uName", theUserName);
        User user = null;
        try{
            user=theQuery.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void save(User user) {
        Session session = factory.getCurrentSession();
        session.save(user);

    }
}
