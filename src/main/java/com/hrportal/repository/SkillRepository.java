package com.hrportal.repository;

import com.hrportal.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
@RepositoryRestResource(collectionResourceRel = "skill", path = "skill")
public interface SkillRepository extends JpaRepository<Skill, Long> {
}
