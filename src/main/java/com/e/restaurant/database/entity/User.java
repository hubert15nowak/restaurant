package com.e.restaurant.database.entity;

import com.e.restaurant.database.enumerate.UserRole;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Type(type = "uuid-char")
    @Column(name = "user_id", length = 36, unique = true)
    private UUID id;

    @Column(length = 45, nullable = false, unique = true)
    private String login;

    @Column(length = 60, nullable = false)
    private String password;

    @Column(nullable = false)
    private UserRole role;

    @OneToOne(mappedBy = "user")
    private Employee employee;


    //Getters


    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }


}
