package com.hrportal.service.impl;

import com.hrportal.model.CustomField;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.CustomFieldRepository;
import com.hrportal.service.ICustomFieldService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
@Service
public class CustomFieldServiceImpl implements ICustomFieldService {

    @Autowired
    private CustomFieldRepository customFieldRepository;


    @Override
    public List<CustomField> getAll() {
        return customFieldRepository.findAll();
    }

    @Override
    public CustomField get(Long id) throws NotFoundException {
        CustomField customField = customFieldRepository.findOne(id);
        if (Objects.isNull(customField)) {
            throw new NotFoundException("CustomField Not found with given id : " + id);
        }
        return customField;
    }

    @Override
    public CustomField save(CustomField call) {
        return customFieldRepository.save(call);
    }

    @Override
    public CustomField update(Long id, CustomField customField) throws NotFoundException {
        if (!customFieldRepository.exists(customField.getId())) {
            throw new NotFoundException("CustomField Not found with given id : " + customField.getId());
        }
        return customFieldRepository.save(customField);
    }

    @Override
    public CustomField delete(Long id) throws NotFoundException {
        CustomField customField = customFieldRepository.findOne(id);
        if (!Objects.isNull(customField)) {
            throw new NotFoundException("CustomField Not found with given id : " + id);
        }
        customField.setRecordStatus(RecordStatus.INACTIVE);
        return customFieldRepository.save(customField);
    }
}
