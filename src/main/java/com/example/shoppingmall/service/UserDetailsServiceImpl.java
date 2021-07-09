package com.example.shoppingmall.service;

import com.example.shoppingmall.Entity.Role;
import com.example.shoppingmall.Entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RoleServiceImpl roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        /*
        Check the user infor
         */
        AppUser user = userService.getOneUserByUsername(username);

        if(user == null) {
            System.out.println("Can not found username: " + username);
            throw new UsernameNotFoundException("User "+username+" can not be found in database");
        }

        System.out.println("Found user " + username);

        /*
        Check the role
         */

        List<Role> roleList = (List<Role>) this.roleService.getRolesByUserName(username);
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
        for (Role role: roleList) {
            GrantedAuthority authority = new SimpleGrantedAuthority(role.getRolename());
            grantedAuthorityList.add(authority);
        }

        UserDetails userDetails = (UserDetails) new User(user.getUsername(), user.getPassword(), grantedAuthorityList);
        return userDetails;
    }
}
