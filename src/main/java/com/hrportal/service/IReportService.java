package com.hrportal.service;

import com.hrportal.model.Report;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
public interface IReportService {

    List<Report> getAll();

    Report get(Long id) throws NotFoundException;

    Report save(Report report);

    Report update(Long id, Report report) throws NotFoundException;

    Report delete(Long id) throws NotFoundException;
}
