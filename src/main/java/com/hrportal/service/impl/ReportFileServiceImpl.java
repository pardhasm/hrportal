package com.hrportal.service.impl;

import com.hrportal.model.RecordStatus;
import com.hrportal.model.ReportFile;
import com.hrportal.repository.ReportFileRepository;
import com.hrportal.service.IReportFileService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
@Service
public class ReportFileServiceImpl implements IReportFileService {

    @Autowired
    private ReportFileRepository reportFileRepository;


    @Override
    public List<ReportFile> getAll() {
        return reportFileRepository.findAll();
    }

    @Override
    public ReportFile get(Long id) throws NotFoundException {
        ReportFile reportFile = reportFileRepository.findOne(id);
        if (Objects.isNull(reportFile)) {
            throw new NotFoundException("ReportFile Not found with given id : " + id);
        }
        return reportFile;
    }

    @Override
    public ReportFile save(ReportFile reportFile) {
        return reportFileRepository.save(reportFile);
    }

    @Override
    public ReportFile update(Long id, ReportFile reportFile) throws NotFoundException {
        if (!reportFileRepository.exists(reportFile.getId())) {
            throw new NotFoundException("ReportFile Not found with given id : " + reportFile.getId());
        }
        return reportFileRepository.save(reportFile);
    }

    @Override
    public ReportFile delete(Long id) throws NotFoundException {
        ReportFile reportFile = reportFileRepository.findOne(id);
        if (!Objects.isNull(reportFile)) {
            throw new NotFoundException("ReportFile Not found with given id : " + id);
        }
        reportFile.setRecordStatus(RecordStatus.INACTIVE);
        return reportFileRepository.save(reportFile);
    }
}
