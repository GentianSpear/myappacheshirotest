package com.springBoot.demo.entity;

import java.util.HashSet;
import java.util.Set;

public class Role {
    private Integer rid;
    private String rname;
    private Set<Permission> permissions=new HashSet<>();
    private Set<User> users=new HashSet<>();

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getName() {
        return rname;
    }

    public void setName(String name) {
        this.rname = rname;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}