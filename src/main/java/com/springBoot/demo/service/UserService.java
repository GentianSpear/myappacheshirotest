package com.springBoot.demo.service;

import com.springBoot.demo.entity.User;

public interface UserService {
    User findUserByUsername(String username);
}
