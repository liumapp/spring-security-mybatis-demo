package com.liumapp.demo.security.auth.user;

import com.liumapp.demo.security.domain.*;
import com.liumapp.demo.security.mapper.RoleMapper;
import com.liumapp.demo.security.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by liumapp on 2/2/18.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public final class JwtUserFactory {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleMapper roleMapper;

    private static JwtUserFactory instance;

    private static synchronized JwtUserFactory getInstance () {
        if (instance == null) {
            instance = new JwtUserFactory();
//            instance.roleMapper =
        }
        return instance;
    }

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getName(),
                null,
                user.getEmail(),
                user.getPhone(),
                user.getPassword(),
                mapToGrantedAuthorities(JwtUserFactory.getInstance().getAuthorities(user)),
                JwtUserFactory.getInstance().convert(user.getIsenabled()),
                user.getType()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> roles) {
        return roles.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toList());
    }

    private List<Role> getAuthorities (User user) {
        UserRoleExample userRoleExample = new UserRoleExample();
        userRoleExample.createCriteria().andUseridEqualTo(user.getId());

        List<UserRole> tmp = userRoleMapper.selectByExample(userRoleExample);
        LinkedList<UserRole> userRoles = new LinkedList<UserRole>(tmp);

        List<Role> roles = getRoles();
        List<Role> result = new LinkedList<Role>();

        while (userRoles.size() > 0) {
            UserRole userRole = userRoles.pop();
            for (int i = 0 ; i < roles.size() ; i++) {
                Role role = roles.get(i);
                if (role.getId().equals(userRole.getRoleid()))
                    result.add(role);
            }
        }

        return result;
    }

    private List<Role> getRoles () {
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andIdIsNotNull();
        return roleMapper.selectByExample(roleExample);
    }

    private boolean convert (byte isenabled) {
        return isenabled == 1 ;
    }

}