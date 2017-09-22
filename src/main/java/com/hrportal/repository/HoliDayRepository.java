package com.hrportal.repository;

import com.hrportal.model.HoliDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
@RepositoryRestResource(collectionResourceRel = "holiDay", path = "holiDay")
public interface HoliDayRepository extends JpaRepository<HoliDay, Long> {
}
