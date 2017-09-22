package com.hrportal.repository;

import com.hrportal.model.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
@RepositoryRestResource(collectionResourceRel = "leaveType", path = "leaveType")
public interface LeaveTypeRepository extends JpaRepository<LeaveType, Long> {
}
