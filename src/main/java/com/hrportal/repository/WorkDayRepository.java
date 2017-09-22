package com.hrportal.repository;

import com.hrportal.model.WorkDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
@RepositoryRestResource(collectionResourceRel = "workDay", path = "workDay")
public interface WorkDayRepository extends JpaRepository<WorkDay, Long> {
}
