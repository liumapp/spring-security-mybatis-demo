package com.liumapp.demo.security.auth.service.impl;

import com.liumapp.demo.security.auth.service.MultyUserDetailsService;
import com.liumapp.demo.security.auth.user.JwtUserFactory;
import com.liumapp.demo.security.domain.User;
import com.liumapp.demo.security.domain.UserExample;
import com.liumapp.demo.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liumapp on 2/2/18.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 * the username here can be email and also can be phone number
 * that dependent on user type
 */
@Service
public class JwtUserDetailsServiceImpl implements MultyUserDetailsService {

    @Autowired
    private UserMapper userMapper;

    /**
     * plz don't use this function
     * @param username
     * @return UserDetail
     * @throws UsernameNotFoundException not found user
     */
    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
        throw new UsernameNotFoundException("plz don't use this function");
    }

    public UserDetails loadUserByEmail (String email) throws UsernameNotFoundException {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andEmailEqualTo(email);

        LinkedList<User> users = (LinkedList<User>) userMapper.selectByExample(userExample);
        User user = users.pop();

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with email '%s'.", email));
        } else {
            return JwtUserFactory.create(user);
        }
    }

    public UserDetails loadUserByPhone (String phone) throws UsernameNotFoundException {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andPhoneEqualTo(phone);

        LinkedList<User> users = (LinkedList<User>) userMapper.selectByExample(userExample);
        User user = users.pop();

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with phone '%s'.", phone));
        } else {
            return JwtUserFactory.create(user);
        }
    }

}
