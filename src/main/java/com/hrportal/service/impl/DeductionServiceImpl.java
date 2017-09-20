package com.hrportal.service.impl;

import com.hrportal.model.Deduction;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.DeductionRepository;
import com.hrportal.service.IDeductionService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
@Service
public class DeductionServiceImpl implements IDeductionService {

    @Autowired
    private DeductionRepository deductionRepository;


    @Override
    public List<Deduction> getAll() {
        return deductionRepository.findAll();
    }

    @Override
    public Deduction get(Long id) throws NotFoundException {
        Deduction deduction = deductionRepository.findOne(id);
        if (Objects.isNull(deduction)) {
            throw new NotFoundException("Deduction Not found with given id : " + id);
        }
        return deduction;
    }

    @Override
    public Deduction save(Deduction deduction) {
        return deductionRepository.save(deduction);
    }

    @Override
    public Deduction update(Long id, Deduction deduction) throws NotFoundException {
        if (!deductionRepository.exists(deduction.getId())) {
            throw new NotFoundException("Deduction Not found with given id : " + deduction.getId());
        }
        return deductionRepository.save(deduction);
    }

    @Override
    public Deduction delete(Long id) throws NotFoundException {
        Deduction deduction = deductionRepository.findOne(id);
        if (!Objects.isNull(deduction)) {
            throw new NotFoundException("Deduction Not found with given id : " + id);
        }
        deduction.setRecordStatus(RecordStatus.INACTIVE);
        return deductionRepository.save(deduction);
    }
}
