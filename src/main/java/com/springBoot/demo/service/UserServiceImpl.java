package com.springBoot.demo.service;

import com.springBoot.demo.entity.User;
import com.springBoot.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUserByUsername(String username) {
        User user=userMapper.findByUsername(username);
        return user;
    }

}
