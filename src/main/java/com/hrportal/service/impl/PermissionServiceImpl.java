package com.hrportal.service.impl;

import com.hrportal.model.Permission;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.PermissionRepository;
import com.hrportal.service.IPermissionService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private PermissionRepository permissionRepository;


    @Override
    public List<Permission> getAll() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission get(Long id) throws NotFoundException {
        Permission permission = permissionRepository.findOne(id);
        if (Objects.isNull(permission)) {
            throw new NotFoundException("Permission Not found with given id : " + id);
        }
        return permission;
    }

    @Override
    public Permission save(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public Permission update(Long id, Permission permission) throws NotFoundException {
        if (!permissionRepository.exists(permission.getId())) {
            throw new NotFoundException("Permission Not found with given id : " + permission.getId());
        }
        return permissionRepository.save(permission);
    }

    @Override
    public Permission delete(Long id) throws NotFoundException {
        Permission permission = permissionRepository.findOne(id);
        if (!Objects.isNull(permission)) {
            throw new NotFoundException("Permission Not found with given id : " + id);
        }
        permission.setRecordStatus(RecordStatus.INACTIVE);
        return permissionRepository.save(permission);
    }
}
