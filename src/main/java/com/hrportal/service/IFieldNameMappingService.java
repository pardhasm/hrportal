package com.hrportal.service;

import com.hrportal.model.FieldNameMapping;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
public interface IFieldNameMappingService {

    List<FieldNameMapping> getAll();

    FieldNameMapping get(Long id) throws NotFoundException;

    FieldNameMapping save(FieldNameMapping fieldNameMapping);

    FieldNameMapping update(Long id, FieldNameMapping fieldNameMapping) throws NotFoundException;

    FieldNameMapping delete(Long id) throws NotFoundException;
}
