package com.vladimirstanciu.accessgranter.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Vladimir on 5/20/2017.
 */
@Entity
@Table(name="Permission")
public class Permission {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "permission")
    private Set<RolePermission> permissionRoles;

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

    public Set<RolePermission> getPermissionRoles() {
        return permissionRoles;
    }

    public void setPermissionRoles(Set<RolePermission> permissionRoles) {
        this.permissionRoles = permissionRoles;
    }
}
