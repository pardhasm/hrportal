package com.hrportal.service;

import com.hrportal.model.ImmigrationDocument;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
public interface IImmigrationDocumentService {

    List<ImmigrationDocument> getAll();

    ImmigrationDocument get(Long id) throws NotFoundException;

    ImmigrationDocument save(ImmigrationDocument immigrationDocument);

    ImmigrationDocument update(Long id, ImmigrationDocument immigrationDocument) throws NotFoundException;

    ImmigrationDocument delete(Long id) throws NotFoundException;
}
