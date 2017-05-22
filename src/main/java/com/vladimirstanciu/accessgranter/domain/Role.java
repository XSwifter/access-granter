package com.vladimirstanciu.accessgranter.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Vladimir on 5/20/2017.
 */
@Entity
@Table(name="Role")
public class Role {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    @JsonManagedReference(value="role")
    private Set<UserRole> roleUsers;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private Set<RolePermission> rolePermissions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserRole> getRoleUsers() {
        return roleUsers;
    }

    public void setRoleUsers(Set<UserRole> roleUsers) {
        this.roleUsers = roleUsers;
    }

    public Set<RolePermission> getRolePermissions() {
        return rolePermissions;
    }

    public void setRolePermissions(Set<RolePermission> rolePermissions) {
        this.rolePermissions = rolePermissions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roleUsers=" + roleUsers +
                ", rolePermissions=" + rolePermissions +
                '}';
    }
}
