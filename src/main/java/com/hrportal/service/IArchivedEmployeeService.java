package com.hrportal.service;

import com.hrportal.model.ArchivedEmployee;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
public interface IArchivedEmployeeService {

    List<ArchivedEmployee> getAll();

    ArchivedEmployee get(Long id) throws NotFoundException;

    ArchivedEmployee save(ArchivedEmployee archivedEmployee);

    ArchivedEmployee update(Long id, ArchivedEmployee archivedEmployee) throws NotFoundException;

    ArchivedEmployee delete(Long id) throws NotFoundException;
}
