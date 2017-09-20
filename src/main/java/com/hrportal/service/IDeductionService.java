package com.hrportal.service;

import com.hrportal.model.Deduction;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
public interface IDeductionService {

    List<Deduction> getAll();

    Deduction get(Long id) throws NotFoundException;

    Deduction save(Deduction deduction);

    Deduction update(Long id, Deduction deduction) throws NotFoundException;

    Deduction delete(Long id) throws NotFoundException;
}
