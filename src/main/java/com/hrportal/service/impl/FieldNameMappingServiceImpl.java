package com.hrportal.service.impl;

import com.hrportal.model.FieldNameMapping;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.FieldNameMappingRepository;
import com.hrportal.service.IFieldNameMappingService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
@Service
public class FieldNameMappingServiceImpl implements IFieldNameMappingService {

    @Autowired
    private FieldNameMappingRepository fieldNameMappingRepository;


    @Override
    public List<FieldNameMapping> getAll() {
        return fieldNameMappingRepository.findAll();
    }

    @Override
    public FieldNameMapping get(Long id) throws NotFoundException {
        FieldNameMapping fieldNameMapping = fieldNameMappingRepository.findOne(id);
        if (Objects.isNull(fieldNameMapping)) {
            throw new NotFoundException("FieldNameMapping Not found with given id : " + id);
        }
        return fieldNameMapping;
    }

    @Override
    public FieldNameMapping save(FieldNameMapping fieldNameMapping) {
        return fieldNameMappingRepository.save(fieldNameMapping);
    }

    @Override
    public FieldNameMapping update(Long id, FieldNameMapping fieldNameMapping) throws NotFoundException {
        if (!fieldNameMappingRepository.exists(fieldNameMapping.getId())) {
            throw new NotFoundException("FieldNameMapping Not found with given id : " + fieldNameMapping.getId());
        }
        return fieldNameMappingRepository.save(fieldNameMapping);
    }

    @Override
    public FieldNameMapping delete(Long id) throws NotFoundException {
        FieldNameMapping fieldNameMapping = fieldNameMappingRepository.findOne(id);
        if (!Objects.isNull(fieldNameMapping)) {
            throw new NotFoundException("FieldNameMapping Not found with given id : " + id);
        }
        fieldNameMapping.setRecordStatus(RecordStatus.INACTIVE);
        return fieldNameMappingRepository.save(fieldNameMapping);
    }
}
