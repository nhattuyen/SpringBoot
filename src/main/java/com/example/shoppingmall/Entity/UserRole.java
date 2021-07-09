package com.example.shoppingmall.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "USERROLE")
public class UserRole {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "username", nullable = false)
    //@Type(type = "json")
    private String username;

    @Column(name = "rolename", nullable = false)
    //@Type(type = "json")
    private String rolename;

    public UserRole() {

    }
}
