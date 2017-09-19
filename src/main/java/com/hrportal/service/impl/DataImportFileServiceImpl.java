package com.hrportal.service.impl;

import com.hrportal.model.DataImportFile;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.DataImportFileRepository;
import com.hrportal.service.IDataImportFileService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
@Service
public class DataImportFileServiceImpl implements IDataImportFileService {

    @Autowired
    private DataImportFileRepository dataImportFileRepository;


    @Override
    public List<DataImportFile> getAll() {
        return dataImportFileRepository.findAll();
    }

    @Override
    public DataImportFile get(Long id) throws NotFoundException {
        DataImportFile dataImportFile = dataImportFileRepository.findOne(id);
        if (Objects.isNull(dataImportFile)) {
            throw new NotFoundException("DataImportFile Not found with given id : " + id);
        }
        return dataImportFile;
    }

    @Override
    public DataImportFile save(DataImportFile dataImportFile) {
        return dataImportFileRepository.save(dataImportFile);
    }

    @Override
    public DataImportFile update(Long id, DataImportFile dataImportFile) throws NotFoundException {
        if (!dataImportFileRepository.exists(dataImportFile.getId())) {
            throw new NotFoundException("DataImportFile Not found with given id : " + dataImportFile.getId());
        }
        return dataImportFileRepository.save(dataImportFile);
    }

    @Override
    public DataImportFile delete(Long id) throws NotFoundException {
        DataImportFile dataImportFile = dataImportFileRepository.findOne(id);
        if (!Objects.isNull(dataImportFile)) {
            throw new NotFoundException("DataImportFile Not found with given id : " + id);
        }
        dataImportFile.setRecordStatus(RecordStatus.INACTIVE);
        return dataImportFileRepository.save(dataImportFile);
    }


}
