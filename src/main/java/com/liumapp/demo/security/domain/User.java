package com.liumapp.demo.security.domain;

import java.util.Date;

public class User {
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String password;

    private Byte isenabled;

    /**
     * 1: 个人
     * 2: 企业
     */
    private Byte type;

    private Date creatat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Byte getIsenabled() {
        return isenabled;
    }

    public void setIsenabled(Byte isenabled) {
        this.isenabled = isenabled;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Date getCreatat() {
        return creatat;
    }

    public void setCreatat(Date creatat) {
        this.creatat = creatat;
    }
}