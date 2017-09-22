package com.hrportal.repository;

import com.hrportal.model.Migration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
@RepositoryRestResource(collectionResourceRel = "migration", path = "migration")
public interface MigrationRepository extends JpaRepository<Migration, Long> {
}
