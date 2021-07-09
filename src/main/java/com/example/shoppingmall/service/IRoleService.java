package com.example.shoppingmall.service;

import com.example.shoppingmall.Entity.Role;

public interface IRoleService {
    Iterable<Role> getAll();

    Role getOneRoleByRolename(String rolename);

    Role getOneRoleById(String id);

    Iterable<Role> getRolesByUserName(String username);

    int addRole(Role role);

    int updateRole(Role role);

    int deleteRoleByRoleName(String rolename);

    int deleteRoleById(String id);
}
