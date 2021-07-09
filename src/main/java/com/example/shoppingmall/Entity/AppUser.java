package com.example.shoppingmall.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "AppUser")
public class AppUser {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "username", length = 30, nullable = false)
    private String username;

    @Column(name = "password", length = 40, nullable = false)
    private String password;

    @Column(name = "isactive")
    private boolean isactive;
}
