package com.liumapp.demo.security.service;

import com.liumapp.demo.security.domain.User;
import com.liumapp.demo.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liumapp on 2/1/18.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int insert (User user) {
        return userMapper.insert(user);
    }

}
