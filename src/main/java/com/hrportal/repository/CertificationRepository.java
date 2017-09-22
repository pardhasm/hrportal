package com.hrportal.repository;

import com.hrportal.model.Certification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
@RepositoryRestResource(collectionResourceRel = "certification", path = "certification")
public interface CertificationRepository extends JpaRepository<Certification, Long> {
}
