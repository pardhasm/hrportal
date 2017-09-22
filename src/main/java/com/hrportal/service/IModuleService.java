package com.hrportal.service;

import com.hrportal.model.Module;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
public interface IModuleService {

    List<Module> getAll();

    Module get(Long id) throws NotFoundException;

    Module save(Module module);

    Module update(Long id, Module module) throws NotFoundException;

    Module delete(Long id) throws NotFoundException;
}
