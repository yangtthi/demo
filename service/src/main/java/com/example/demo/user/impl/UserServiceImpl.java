package com.example.demo.user.impl;

import com.example.demo.entity.test.User;
import com.example.demo.dao.UserDao;
import com.example.demo.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yangtthi on 18/3/11.
 */
@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }
}
