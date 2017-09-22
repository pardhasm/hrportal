package com.hrportal.service.impl;

import com.hrportal.model.ImmigrationDocument;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.ImmigrationDocumentRepository;
import com.hrportal.service.IImmigrationDocumentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
@Service
public class ImmigrationDocumentServiceImpl implements IImmigrationDocumentService {

    @Autowired
    private ImmigrationDocumentRepository immigrationDocumentRepository;


    @Override
    public List<ImmigrationDocument> getAll() {
        return immigrationDocumentRepository.findAll();
    }

    @Override
    public ImmigrationDocument get(Long id) throws NotFoundException {
        ImmigrationDocument immigrationDocument = immigrationDocumentRepository.findOne(id);
        if (Objects.isNull(immigrationDocument)) {
            throw new NotFoundException("ImmigrationDocument Not found with given id : " + id);
        }
        return immigrationDocument;
    }

    @Override
    public ImmigrationDocument save(ImmigrationDocument immigrationDocument) {
        return immigrationDocumentRepository.save(immigrationDocument);
    }

    @Override
    public ImmigrationDocument update(Long id, ImmigrationDocument immigrationDocument) throws NotFoundException {
        if (!immigrationDocumentRepository.exists(immigrationDocument.getId())) {
            throw new NotFoundException("ImmigrationDocument Not found with given id : " + immigrationDocument.getId());
        }
        return immigrationDocumentRepository.save(immigrationDocument);
    }

    @Override
    public ImmigrationDocument delete(Long id) throws NotFoundException {
        ImmigrationDocument immigrationDocument = immigrationDocumentRepository.findOne(id);
        if (!Objects.isNull(immigrationDocument)) {
            throw new NotFoundException("ImmigrationDocument Not found with given id : " + id);
        }
        immigrationDocument.setRecordStatus(RecordStatus.INACTIVE);
        return immigrationDocumentRepository.save(immigrationDocument);
    }
}
