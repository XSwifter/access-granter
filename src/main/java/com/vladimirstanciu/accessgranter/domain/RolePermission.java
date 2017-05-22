package com.vladimirstanciu.accessgranter.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * Created by Vladimir on 5/20/2017.
 */
@Entity
@Table(name="Role_Permission")
public class RolePermission {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "permission_id")
    @JsonBackReference(value="perm")
    private Permission permission;

    @ManyToOne
    @JoinColumn(name = "role_id")
    @JsonBackReference(value="role")
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
