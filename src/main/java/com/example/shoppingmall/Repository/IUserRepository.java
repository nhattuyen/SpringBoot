package com.example.shoppingmall.Repository;

import com.example.shoppingmall.Entity.AppUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IUserRepository extends CrudRepository<AppUser, Integer> {
    AppUser findUserById(String id);
    AppUser findUserByUsername(String username);
    List<AppUser> findByUsernameIsNotNull();
    List<AppUser> existsUserByIsactiveIsTrue();
    List<AppUser> existsUserByIsactiveIsFalse();
    AppUser existsUserByUsernameAndPassword(String username, String password);
    boolean existsUserByUsernameAndPasswordAndIsactive(String username, String password, boolean isactive);
    int deleteUserByUsername(String username);
    int deleteUserById(String id);
}
