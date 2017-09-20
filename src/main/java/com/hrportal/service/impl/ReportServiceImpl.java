package com.hrportal.service.impl;

import com.hrportal.model.RecordStatus;
import com.hrportal.model.Report;
import com.hrportal.repository.ReportRepository;
import com.hrportal.service.IReportService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
@Service
public class ReportServiceImpl implements IReportService {

    @Autowired
    private ReportRepository reportRepository;


    @Override
    public List<Report> getAll() {
        return reportRepository.findAll();
    }

    @Override
    public Report get(Long id) throws NotFoundException {
        Report report = reportRepository.findOne(id);
        if (Objects.isNull(report)) {
            throw new NotFoundException("Report Not found with given id : " + id);
        }
        return report;
    }

    @Override
    public Report save(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public Report update(Long id, Report report) throws NotFoundException {
        if (!reportRepository.exists(report.getId())) {
            throw new NotFoundException("Report Not found with given id : " + report.getId());
        }
        return reportRepository.save(report);
    }

    @Override
    public Report delete(Long id) throws NotFoundException {
        Report report = reportRepository.findOne(id);
        if (!Objects.isNull(report)) {
            throw new NotFoundException("Report Not found with given id : " + id);
        }
        report.setRecordStatus(RecordStatus.INACTIVE);
        return reportRepository.save(report);
    }
}
