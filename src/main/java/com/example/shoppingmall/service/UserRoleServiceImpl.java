package com.example.shoppingmall.service;

import com.example.shoppingmall.Entity.Role;
import com.example.shoppingmall.Entity.AppUser;
import com.example.shoppingmall.Entity.UserRole;
import com.example.shoppingmall.Repository.IUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserRoleServiceImpl implements IUserRoleService {
    @Autowired
    private IUserRoleRepository userRoleRepository;

    @Override
    public Iterable<UserRole> getAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public Iterable<UserRole> getUserRoleByUsername(String username) {
        return userRoleRepository.findUserRoleByUsername(username);
    }

    @Override
    public UserRole getOneUserRoleById(String id) {
        return userRoleRepository.findUserRoleById(id);
    }

    @Override
    public UserRole getOneUserRoleByUsernameAndRolename(String username, String rolename) {
        return userRoleRepository.findUserRoleByUsernameEqualsAndRolenameEquals(username, rolename);
    }

    @Override
    public boolean isExistUserRoleByUsernameAndRolename(String username, String rolename) {
        return userRoleRepository.existsUserRoleByUsernameEqualsAndAndRolenameEquals(username, rolename);
    }

    @Override
    public int addUserRole(AppUser user, Role role) {
        if(!isExistUserRoleByUsernameAndRolename(user.getUsername(), role.getRolename())) {
            UserRole ur = new UserRole();
            ur.setUsername(user.getUsername());
            ur.setUsername(role.getRolename());
            userRoleRepository.save(ur);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateUserRole(AppUser user, Role role) {
        if(isExistUserRoleByUsernameAndRolename(user.getUsername(), role.getRolename())) {
            UserRole ur = getOneUserRoleByUsernameAndRolename(user.getUsername(), role.getRolename());
            ur.setUsername(user.getUsername());
            ur.setUsername(role.getRolename());
            userRoleRepository.save(ur);
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteUserRoleByUsernameAndRolename(AppUser user, Role role) {
        UserRole ur = getOneUserRoleByUsernameAndRolename(user.getUsername(), role.getRolename());
        if (ur != null) {
            userRoleRepository.deleteUserRolesById(String.valueOf(ur.getId()));
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteUserRoleById(String id) {
        return deleteUserRoleById(id);
    }
}
