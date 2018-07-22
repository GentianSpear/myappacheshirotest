package com.springBoot.demo.mapper;

import com.springBoot.demo.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User findByUsername(@Param("username") String username);
}
