package com.hrportal.repository;

import com.hrportal.model.StatusChangeLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Pardha Saradhi Mavilla
 */
public interface StatusChangeLogRepository extends JpaRepository<StatusChangeLog, Long> {
}
