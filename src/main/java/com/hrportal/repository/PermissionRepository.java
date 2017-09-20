package com.hrportal.repository;

import com.hrportal.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
