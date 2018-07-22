package com.springBoot.demo.entity;

import java.util.HashSet;
import java.util.Set;

public class User {
    private Integer uid;
    private String username;
    private String password;
    private Set<Role> roles=new HashSet<>();

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsernmae() {
        return username;
    }

    public void setUsernmae(String usernmae) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
