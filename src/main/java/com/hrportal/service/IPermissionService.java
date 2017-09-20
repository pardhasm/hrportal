package com.hrportal.service;

import com.hrportal.model.Permission;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
public interface IPermissionService {

    List<Permission> getAll();

    Permission get(Long id) throws NotFoundException;

    Permission save(Permission permission);

    Permission update(Long id, Permission permission) throws NotFoundException;

    Permission delete(Long id) throws NotFoundException;
}
