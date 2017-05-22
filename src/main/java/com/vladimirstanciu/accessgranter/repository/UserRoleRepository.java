package com.vladimirstanciu.accessgranter.repository;

import com.vladimirstanciu.accessgranter.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Vladimir on 5/22/2017.
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    @Query("SELECT ur FROM UserRole ur WHERE ur.user.id = :userId AND ur.role.id = :roleId")
    UserRole findByUserIdAndRoleId(@Param("userId") Long userId, @Param("roleId") Long roleId);
}
