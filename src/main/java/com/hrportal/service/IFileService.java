package com.hrportal.service;

import com.hrportal.model.File;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
public interface IFileService {

    List<File> getAll();

    File get(Long id) throws NotFoundException;

    File save(File file);

    File update(Long id, File file) throws NotFoundException;

    File delete(Long id) throws NotFoundException;
}
