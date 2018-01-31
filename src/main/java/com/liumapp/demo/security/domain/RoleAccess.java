package com.liumapp.demo.security.domain;

public class RoleAccess {
    private Long id;

    private Long roleid;

    private Long accessid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public Long getAccessid() {
        return accessid;
    }

    public void setAccessid(Long accessid) {
        this.accessid = accessid;
    }
}