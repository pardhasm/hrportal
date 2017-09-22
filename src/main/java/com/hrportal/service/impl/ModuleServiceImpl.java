package com.hrportal.service.impl;

import com.hrportal.model.Module;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.ModuleRepository;
import com.hrportal.service.IModuleService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
@Service
public class ModuleServiceImpl implements IModuleService {

    @Autowired
    private ModuleRepository moduleRepository;


    @Override
    public List<Module> getAll() {
        return moduleRepository.findAll();
    }

    @Override
    public Module get(Long id) throws NotFoundException {
        Module module = moduleRepository.findOne(id);
        if (Objects.isNull(module)) {
            throw new NotFoundException("Module Not found with given id : " + id);
        }
        return module;
    }

    @Override
    public Module save(Module module) {
        return moduleRepository.save(module);
    }

    @Override
    public Module update(Long id, Module module) throws NotFoundException {
        if (!moduleRepository.exists(module.getId())) {
            throw new NotFoundException("Module Not found with given id : " + module.getId());
        }
        return moduleRepository.save(module);
    }

    @Override
    public Module delete(Long id) throws NotFoundException {
        Module module = moduleRepository.findOne(id);
        if (!Objects.isNull(module)) {
            throw new NotFoundException("Module Not found with given id : " + id);
        }
        module.setRecordStatus(RecordStatus.INACTIVE);
        return moduleRepository.save(module);
    }
}
