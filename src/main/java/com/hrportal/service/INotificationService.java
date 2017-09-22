package com.hrportal.service;

import com.hrportal.model.Notification;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
public interface INotificationService {

    List<Notification> getAll();

    Notification get(Long id) throws NotFoundException;

    Notification save(Notification notification);

    Notification update(Long id, Notification notification) throws NotFoundException;

    Notification delete(Long id) throws NotFoundException;
}
