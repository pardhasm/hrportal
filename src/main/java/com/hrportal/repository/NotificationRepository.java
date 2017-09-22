package com.hrportal.repository;

import com.hrportal.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
