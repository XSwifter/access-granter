package com.vladimirstanciu.accessgranter.repository;

import com.vladimirstanciu.accessgranter.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vladimir on 5/21/2017.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT r FROM UserRole ur INNER JOIN ur.role r INNER JOIN ur.user u WHERE u.id = :id")
    List<Role> findActiveRoles(@Param("id") Long id);

    @Query("SELECT r FROM Role r WHERE r.id NOT IN (SELECT ur.role.id FROM UserRole ur INNER JOIN ur.user u WHERE u.id = :id)")
    List<Role> findAvailableRoles(@Param("id") Long id);
}
