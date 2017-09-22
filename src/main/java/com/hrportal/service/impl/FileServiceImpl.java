package com.hrportal.service.impl;

import com.hrportal.model.File;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.FileRepository;
import com.hrportal.service.IFileService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
@Service
public class FileServiceImpl implements IFileService {

    @Autowired
    private FileRepository fileRepository;


    @Override
    public List<File> getAll() {
        return fileRepository.findAll();
    }

    @Override
    public File get(Long id) throws NotFoundException {
        File file = fileRepository.findOne(id);
        if (Objects.isNull(file)) {
            throw new NotFoundException("File Not found with given id : " + id);
        }
        return file;
    }

    @Override
    public File save(File file) {
        return fileRepository.save(file);
    }

    @Override
    public File update(Long id, File file) throws NotFoundException {
        if (!fileRepository.exists(file.getId())) {
            throw new NotFoundException("File Not found with given id : " + file.getId());
        }
        return fileRepository.save(file);
    }

    @Override
    public File delete(Long id) throws NotFoundException {
        File file = fileRepository.findOne(id);
        if (!Objects.isNull(file)) {
            throw new NotFoundException("File Not found with given id : " + id);
        }
        file.setRecordStatus(RecordStatus.INACTIVE);
        return fileRepository.save(file);
    }
}
