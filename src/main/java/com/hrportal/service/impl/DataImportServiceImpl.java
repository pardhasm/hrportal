package com.hrportal.service.impl;

import com.hrportal.model.DataImport;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.DataImportRepository;
import com.hrportal.service.IDataImportService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
@Service
public class DataImportServiceImpl implements IDataImportService {

    @Autowired
    private DataImportRepository dataImportRepository;


    @Override
    public List<DataImport> getAll() {
        return dataImportRepository.findAll();
    }

    @Override
    public DataImport get(Long id) throws NotFoundException {
        DataImport dataImport = dataImportRepository.findOne(id);
        if (Objects.isNull(dataImport)) {
            throw new NotFoundException("DataImport Not found with given id : " + id);
        }
        return dataImport;
    }

    @Override
    public DataImport save(DataImport dataImport) {
        return dataImportRepository.save(dataImport);
    }

    @Override
    public DataImport update(Long id, DataImport dataImport) throws NotFoundException {
        if (!dataImportRepository.exists(dataImport.getId())) {
            throw new NotFoundException("DataImport Not found with given id : " + dataImport.getId());
        }
        return dataImportRepository.save(dataImport);
    }

    @Override
    public DataImport delete(Long id) throws NotFoundException {
        DataImport dataImport = dataImportRepository.findOne(id);
        if (!Objects.isNull(dataImport)) {
            throw new NotFoundException("DataImport Not found with given id : " + id);
        }
        dataImport.setRecordStatus(RecordStatus.INACTIVE);
        return dataImportRepository.save(dataImport);
    }
}
