package com.hrportal.service;

import com.hrportal.model.CustomFieldValue;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
public interface ICustomFieldValueService {

    List<CustomFieldValue> getAll();

    CustomFieldValue get(Long id) throws NotFoundException;

    CustomFieldValue save(CustomFieldValue customFieldValue);

    CustomFieldValue update(Long id, CustomFieldValue customFieldValue) throws NotFoundException;

    CustomFieldValue delete(Long id) throws NotFoundException;
}
