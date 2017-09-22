package com.hrportal.service.impl;

import com.hrportal.model.Form;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.FormRepository;
import com.hrportal.service.IFormService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
@Service
public class FormServiceImpl implements IFormService {

    @Autowired
    private FormRepository formRepository;


    @Override
    public List<Form> getAll() {
        return formRepository.findAll();
    }

    @Override
    public Form get(Long id) throws NotFoundException {
        Form form = formRepository.findOne(id);
        if (Objects.isNull(form)) {
            throw new NotFoundException("Form Not found with given id : " + id);
        }
        return form;
    }

    @Override
    public Form save(Form form) {
        return formRepository.save(form);
    }

    @Override
    public Form update(Long id, Form form) throws NotFoundException {
        if (!formRepository.exists(form.getId())) {
            throw new NotFoundException("Form Not found with given id : " + form.getId());
        }
        return formRepository.save(form);
    }

    @Override
    public Form delete(Long id) throws NotFoundException {
        Form form = formRepository.findOne(id);
        if (!Objects.isNull(form)) {
            throw new NotFoundException("Form Not found with given id : " + id);
        }
        form.setRecordStatus(RecordStatus.INACTIVE);
        return formRepository.save(form);
    }
}
