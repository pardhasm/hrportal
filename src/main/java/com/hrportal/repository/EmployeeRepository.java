package com.hrportal.repository;

import com.hrportal.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
