package com.example.shoppingmall.Repository;

import com.example.shoppingmall.Entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRoleRepository extends CrudRepository<Role, Integer> {

    Role findRoleById(String id);
    Role findRoleByRolenameIsLike(String rolename);
    List<Role> findRoleByRolenameIsNotNull();
    boolean existsRoleByRolenameIsLike(String rolename);
    int deleteRoleByRolename(String rolename);
    int deleteRoleById(String id);
}
