package com.hrportal.service;

import com.hrportal.model.Form;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
public interface IFormService {

    List<Form> getAll();

    Form get(Long id) throws NotFoundException;

    Form save(Form form);

    Form update(Long id, Form form) throws NotFoundException;

    Form delete(Long id) throws NotFoundException;
}
