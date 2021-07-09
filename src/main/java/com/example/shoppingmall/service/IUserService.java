package com.example.shoppingmall.service;

import com.example.shoppingmall.Entity.AppUser;

public interface IUserService {
    Iterable<AppUser> getAll();

    AppUser getOneUserByUsername(String username);

    int addUser(AppUser user);

    int updateUser(AppUser user);

    int deleteUserByUsername(String username);

    int deleteUserByID(String id);
}
