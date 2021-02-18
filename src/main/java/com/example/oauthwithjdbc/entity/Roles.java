package com.example.oauthwithjdbc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
public class Roles implements GrantedAuthority  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roleId;
    private String authority;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "permission_role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private List<Permission> permissions;

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
    public String getAuthority1() {
        return this.authority;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public Roles(String authority, List<Permission> permissions) {
        this.authority = authority;
        this.permissions = permissions;
    }

    public Roles(String authority) {
        this.authority = authority;
    }
}
