package com.example.shoppingmall.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ROLE")
public class Role {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "rolename", length = 40, nullable = false)
    private String rolename;

    public Role() {

    }
}
