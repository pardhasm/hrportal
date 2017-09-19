package com.hrportal.service.impl;

import com.hrportal.model.CustomFieldValue;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.CustomFieldValueRepository;
import com.hrportal.service.ICustomFieldValueService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
@Service
public class CustomFieldValueServiceImpl implements ICustomFieldValueService {

    @Autowired
    private CustomFieldValueRepository customFieldValueRepository;


    @Override
    public List<CustomFieldValue> getAll() {
        return customFieldValueRepository.findAll();
    }

    @Override
    public CustomFieldValue get(Long id) throws NotFoundException {
        CustomFieldValue customFieldValue = customFieldValueRepository.findOne(id);
        if (Objects.isNull(customFieldValue)) {
            throw new NotFoundException("CustomFieldValue Not found with given id : " + id);
        }
        return customFieldValue;
    }

    @Override
    public CustomFieldValue save(CustomFieldValue customFieldValue) {
        return customFieldValueRepository.save(customFieldValue);
    }

    @Override
    public CustomFieldValue update(Long id, CustomFieldValue customFieldValue) throws NotFoundException {
        if (!customFieldValueRepository.exists(customFieldValue.getId())) {
            throw new NotFoundException("CustomFieldValue Not found with given id : " + customFieldValue.getId());
        }
        return customFieldValueRepository.save(customFieldValue);
    }

    @Override
    public CustomFieldValue delete(Long id) throws NotFoundException {
        CustomFieldValue customFieldValue = customFieldValueRepository.findOne(id);
        if (!Objects.isNull(customFieldValue)) {
            throw new NotFoundException("CustomFieldValue Not found with given id : " + id);
        }
        customFieldValue.setRecordStatus(RecordStatus.INACTIVE);
        return customFieldValueRepository.save(customFieldValue);
    }
}
