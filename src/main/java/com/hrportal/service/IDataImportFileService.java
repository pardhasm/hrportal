package com.hrportal.service;

import com.hrportal.model.DataImportFile;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
public interface IDataImportFileService {

    List<DataImportFile> getAll();

    DataImportFile get(Long id) throws NotFoundException;

    DataImportFile save(DataImportFile dataImportFile);

    DataImportFile update(Long id, DataImportFile dataImportFile) throws NotFoundException;

    DataImportFile delete(Long id) throws NotFoundException;
}
