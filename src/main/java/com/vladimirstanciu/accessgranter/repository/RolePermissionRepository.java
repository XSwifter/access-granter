package com.vladimirstanciu.accessgranter.repository;

import com.vladimirstanciu.accessgranter.domain.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vladimir on 5/22/2017.
 */
@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, Long> {
}
