package com.vladimirstanciu.accessgranter.repository;

import com.vladimirstanciu.accessgranter.domain.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Vladimir on 5/22/2017.
 */
@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, Long> {

    @Query("SELECT rp FROM RolePermission rp WHERE rp.role.id = :roleId AND rp.permission.id = :permId")
    RolePermission findByRoleIdAndPermId(@Param("roleId") Long roleId, @Param("permId") Long permId);
}
