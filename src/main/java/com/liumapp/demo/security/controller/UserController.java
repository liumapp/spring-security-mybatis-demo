package com.liumapp.demo.security.controller;

import com.liumapp.demo.security.domain.User;
import com.liumapp.demo.security.domain.UserExample;
import com.liumapp.demo.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by liumapp on 1/31/18.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;


    @RequestMapping("/")
    public String index () {
        return "hello , this is " + this.getClass().getSimpleName();
    }

    @RequestMapping("/list")
    public String list () {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdIsNotNull();
        List<User> lists = userMapper.selectByExample(userExample);
        return lists.toString();
    }

    
}
