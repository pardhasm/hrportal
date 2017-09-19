package com.hrportal.service;

import com.hrportal.model.Document;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
public interface IDocumentService {

    List<Document> getAll();

    Document get(Long id) throws NotFoundException;

    Document save(Document document);

    Document update(Long id, Document document) throws NotFoundException;

    Document delete(Long id) throws NotFoundException;
}
