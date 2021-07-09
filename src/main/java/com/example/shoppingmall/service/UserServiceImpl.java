package com.example.shoppingmall.service;

import com.example.shoppingmall.Entity.AppUser;
import com.example.shoppingmall.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public Iterable<AppUser> getAll() {
        return userRepository.findAll();
    }

    @Override
    public AppUser getOneUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public int addUser(AppUser user) {
        AppUser u = getOneUserByUsername(user.getUsername());
        if (u == null) {
            userRepository.save(u);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateUser(AppUser user) {
        AppUser u = getOneUserByUsername(user.getUsername());
        if (u != null) {
            userRepository.save(u);
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteUserByUsername(String username) {
        return userRepository.deleteUserByUsername(username);
    }

    @Override
    public int deleteUserByID(String id) {
        return userRepository.deleteUserById(id);
    }
}
