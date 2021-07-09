package com.example.shoppingmall.service;

import com.example.shoppingmall.Entity.Role;
import com.example.shoppingmall.Entity.AppUser;
import com.example.shoppingmall.Entity.UserRole;

public interface IUserRoleService {
    Iterable<UserRole> getAll();

    Iterable<UserRole> getUserRoleByUsername(String username);

    UserRole getOneUserRoleById(String id);

    UserRole getOneUserRoleByUsernameAndRolename(String username, String rolename);

    boolean isExistUserRoleByUsernameAndRolename(String username, String rolename);

    int addUserRole(AppUser user, Role role);

    int updateUserRole(AppUser user, Role role);

    int deleteUserRoleByUsernameAndRolename(AppUser user, Role role);

    int deleteUserRoleById(String id);
}
