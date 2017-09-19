package com.hrportal.service;

import com.hrportal.model.DataImport;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
public interface IDataImportService {

    List<DataImport> getAll();

    DataImport get(Long id) throws NotFoundException;

    DataImport save(DataImport dataImport);

    DataImport update(Long id, DataImport dataImport) throws NotFoundException;

    DataImport delete(Long id) throws NotFoundException;
}
