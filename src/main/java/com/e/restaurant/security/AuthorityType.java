package com.e.restaurant.security;

import com.e.restaurant.database.enumerate.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;


public enum AuthorityType implements GrantedAuthority {
    EMPLOYEE("ROLE_EMPLOYEE"),
    ADMIN("ROLE_ADMIN"),
    MANAGER("ROLE_MANAGER"),
    ANONYMOUS("ROLE_ANONYMOUS");

    public final String role;

    AuthorityType(String role) {
        this.role = role;
    }

    public List<SimpleGrantedAuthority> getGrantedAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }

    public static AuthorityType getAuthority(UserRole s) {
        switch(s) {
            case ADMIN:
                return ADMIN;
            case MANAGER:
                return MANAGER;
            case EMPLOYEE:
                return EMPLOYEE;
            default:
                return ANONYMOUS;
        }
    }

    @Override
    public String getAuthority() {
        return this.name();
    }
}
