package com.hrportal.service;

import com.hrportal.model.ReportFile;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
public interface IReportFileService {

    List<ReportFile> getAll();

    ReportFile get(Long id) throws NotFoundException;

    ReportFile save(ReportFile reportFile);

    ReportFile update(Long id, ReportFile reportFile) throws NotFoundException;

    ReportFile delete(Long id) throws NotFoundException;
}
