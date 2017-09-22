package com.hrportal.repository;

import com.hrportal.model.Nationality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
@RepositoryRestResource(collectionResourceRel = "nationality", path = "nationality")
public interface NationalityRepository extends JpaRepository<Nationality, Long> {
}
