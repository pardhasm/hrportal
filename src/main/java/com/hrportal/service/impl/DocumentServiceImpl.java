package com.hrportal.service.impl;

import com.hrportal.model.Document;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.DocumentRepository;
import com.hrportal.service.IDocumentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
@Service
public class DocumentServiceImpl implements IDocumentService {

    @Autowired
    private DocumentRepository documentRepository;


    @Override
    public List<Document> getAll() {
        return documentRepository.findAll();
    }

    @Override
    public Document get(Long id) throws NotFoundException {
        Document document = documentRepository.findOne(id);
        if (Objects.isNull(document)) {
            throw new NotFoundException("Document Not found with given id : " + id);
        }
        return document;
    }

    @Override
    public Document save(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public Document update(Long id, Document document) throws NotFoundException {
        if (!documentRepository.exists(document.getId())) {
            throw new NotFoundException("Document Not found with given id : " + document.getId());
        }
        return documentRepository.save(document);
    }

    @Override
    public Document delete(Long id) throws NotFoundException {
        Document document = documentRepository.findOne(id);
        if (!Objects.isNull(document)) {
            throw new NotFoundException("Document Not found with given id : " + id);
        }
        document.setRecordStatus(RecordStatus.INACTIVE);
        return documentRepository.save(document);
    }
}
