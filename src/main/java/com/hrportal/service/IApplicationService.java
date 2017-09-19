package com.hrportal.service;

import com.hrportal.model.Application;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
public interface IApplicationService {

    List<Application> getAll();

    Application get(Long id) throws NotFoundException;

    Application save(Application application);

    Application update(Long id, Application application) throws NotFoundException;

    Application delete(Long id) throws NotFoundException;
}
