package com.example.oauthwithjdbc.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;


@Entity
public class Role implements GrantedAuthority  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roleId;
    private String authority;

    public Role() {
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public long getRoleId() {
        return roleId;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public Role(String authority) {
        this.authority = authority;
    }
}
