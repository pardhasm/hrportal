package com.hrportal.repository;

import com.hrportal.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
public interface EmailRepository extends JpaRepository<Email, Long> {
}
