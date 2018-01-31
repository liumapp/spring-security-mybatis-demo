package com.liumapp.demo.security.domain;

import java.util.Date;

public class Access {
    private Long id;

    private Long fid;

    private String module;

    private String controller;

    private String function;

    private Date creatat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module == null ? null : module.trim();
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller == null ? null : controller.trim();
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function == null ? null : function.trim();
    }

    public Date getCreatat() {
        return creatat;
    }

    public void setCreatat(Date creatat) {
        this.creatat = creatat;
    }
}