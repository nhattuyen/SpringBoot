package com.example.shoppingmall.service;

import com.example.shoppingmall.Entity.Role;
import com.example.shoppingmall.Entity.UserRole;
import com.example.shoppingmall.Repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService{

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public Iterable<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role getOneRoleByRolename(String rolename) {
        return roleRepository.findRoleByRolenameIsLike(rolename);
    }

    @Override
    public Role getOneRoleById(String id) {
        return roleRepository.findRoleById(id);
    }

    @Override
    public Iterable<Role> getRolesByUserName(String username) {
        UserRoleServiceImpl userRoleService = new UserRoleServiceImpl();
        List<Role> roleList = (List<Role>) getAll();
        List<Role> roles = new ArrayList<Role>();
        List<UserRole> userRoleList = (List<UserRole>) userRoleService.getAll();
        for (UserRole userRole: userRoleList) {
            if (userRole.getUsername().equals(username)){
                for (Role role: roleList) {
                    if(userRole.getRolename().equals(role.getRolename())) {
                        roles.add(role);
                    }
                }
            }

        }
        
        return roles;
    }

    @Override
    public int addRole(Role role) {
        Role r = getOneRoleByRolename(role.getRolename());
        if(r == null) {
            roleRepository.save(role);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateRole(Role role) {
        Role r = getOneRoleByRolename(role.getRolename());
        if(r != null) {
            roleRepository.save(role);
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteRoleByRoleName(String rolename) {
        return roleRepository.deleteRoleByRolename(rolename);
    }

    @Override
    public int deleteRoleById(String id) {
        return roleRepository.deleteRoleById(id)    ;
    }

}