package com.hrportal.repository;

import com.hrportal.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
