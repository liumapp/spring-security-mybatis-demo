package com.liumapp.demo.security.controller;

import com.liumapp.demo.security.domain.User;
import com.liumapp.demo.security.mapper.UserMapper;
import com.liumapp.demo.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liumapp on 1/31/18.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index () {
        return "hello , this is " + this.getClass().getSimpleName();
    }

    @RequestMapping("/add")
    public String add (@RequestBody User user) {
        userService.insert(user);
        return "success";
    }

    
}
