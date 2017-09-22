package com.hrportal.service.impl;

import com.hrportal.model.Notification;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.NotificationRepository;
import com.hrportal.service.INotificationService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
@Service
public class NotificationServiceImpl implements INotificationService {

    @Autowired
    private NotificationRepository notificationRepository;


    @Override
    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }

    @Override
    public Notification get(Long id) throws NotFoundException {
        Notification notification = notificationRepository.findOne(id);
        if (Objects.isNull(notification)) {
            throw new NotFoundException("Notification Not found with given id : " + id);
        }
        return notification;
    }

    @Override
    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification update(Long id, Notification notification) throws NotFoundException {
        if (!notificationRepository.exists(notification.getId())) {
            throw new NotFoundException("Notification Not found with given id : " + notification.getId());
        }
        return notificationRepository.save(notification);
    }

    @Override
    public Notification delete(Long id) throws NotFoundException {
        Notification notification = notificationRepository.findOne(id);
        if (!Objects.isNull(notification)) {
            throw new NotFoundException("Notification Not found with given id : " + id);
        }
        notification.setRecordStatus(RecordStatus.INACTIVE);
        return notificationRepository.save(notification);
    }
}
