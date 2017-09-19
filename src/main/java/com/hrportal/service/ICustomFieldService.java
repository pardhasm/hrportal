package com.hrportal.service;

import com.hrportal.model.CustomField;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
public interface ICustomFieldService {

    List<CustomField> getAll();

    CustomField get(Long id) throws NotFoundException;

    CustomField save(CustomField customField);

    CustomField update(Long id, CustomField customField) throws NotFoundException;

    CustomField delete(Long id) throws NotFoundException;
}

