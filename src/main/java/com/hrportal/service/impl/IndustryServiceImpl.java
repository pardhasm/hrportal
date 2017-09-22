package com.hrportal.service.impl;

import com.hrportal.model.Industry;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.IndustryRepository;
import com.hrportal.service.IIndustryService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
@Service
public class IndustryServiceImpl implements IIndustryService {

    @Autowired
    private IndustryRepository industryRepository;


    @Override
    public List<Industry> getAll() {
        return industryRepository.findAll();
    }

    @Override
    public Industry get(Long id) throws NotFoundException {
        Industry industry = industryRepository.findOne(id);
        if (Objects.isNull(industry)) {
            throw new NotFoundException("Industry Not found with given id : " + id);
        }
        return industry;
    }

    @Override
    public Industry save(Industry industry) {
        return industryRepository.save(industry);
    }

    @Override
    public Industry update(Long id, Industry industry) throws NotFoundException {
        if (!industryRepository.exists(industry.getId())) {
            throw new NotFoundException("Industry Not found with given id : " + industry.getId());
        }
        return industryRepository.save(industry);
    }

    @Override
    public Industry delete(Long id) throws NotFoundException {
        Industry industry = industryRepository.findOne(id);
        if (!Objects.isNull(industry)) {
            throw new NotFoundException("Industry Not found with given id : " + id);
        }
        industry.setRecordStatus(RecordStatus.INACTIVE);
        return industryRepository.save(industry);
    }
}
