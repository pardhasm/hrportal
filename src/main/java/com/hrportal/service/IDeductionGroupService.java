package com.hrportal.service;

import com.hrportal.model.DeductionGroup;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
public interface IDeductionGroupService {

    List<DeductionGroup> getAll();

    DeductionGroup get(Long id) throws NotFoundException;

    DeductionGroup save(DeductionGroup deductionGroup);

    DeductionGroup update(Long id, DeductionGroup deductionGroup) throws NotFoundException;

    DeductionGroup delete(Long id) throws NotFoundException;
}
