package com.hrportal.service;

import com.hrportal.model.Industry;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
public interface IIndustryService {

    List<Industry> getAll();

    Industry get(Long id) throws NotFoundException;

    Industry save(Industry industry);

    Industry update(Long id, Industry industry) throws NotFoundException;

    Industry delete(Long id) throws NotFoundException;
}
