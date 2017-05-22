package com.vladimirstanciu.accessgranter.repository;

import com.vladimirstanciu.accessgranter.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vladimir on 5/21/2017.
 */
@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
