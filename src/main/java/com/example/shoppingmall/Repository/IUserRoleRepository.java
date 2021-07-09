package com.example.shoppingmall.Repository;

import com.example.shoppingmall.Entity.UserRole;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IUserRoleRepository extends CrudRepository<UserRole, Integer> {
    UserRole findUserRoleById(String id);
    List<UserRole> findUserRoleByUsername(String Username);
    boolean existsUserRoleByUsernameEqualsAndAndRolenameEquals(String username, String rolename);
    UserRole findUserRoleByUsernameEqualsAndRolenameEquals(String username, String rolename);
    int deleteUserRolesByRolename(String rolename);
    int deleteUserRolesByUsername(String username);
    int deleteUserRolesById(String id);
}
