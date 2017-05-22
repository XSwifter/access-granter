package com.vladimirstanciu.accessgranter.repository;

import com.vladimirstanciu.accessgranter.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vladimir on 5/21/2017.
 */
@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    @Query("SELECT p FROM RolePermission rp INNER JOIN rp.permission p INNER JOIN rp.role r WHERE r.id = :id")
    List<Permission> findActivePermissions(@Param("id") Long id);

    @Query("SELECT p FROM Permission p WHERE p.id NOT IN (SELECT rp.permission.id FROM RolePermission rp INNER JOIN rp.role r WHERE r.id = :id)")
    List<Permission> findAvailablePermissions(@Param("id") Long id);

}
