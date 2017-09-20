package com.hrportal.service.impl;

import com.hrportal.model.DeductionGroup;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.DeductionGroupRepository;
import com.hrportal.service.IDeductionGroupService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
@Service
public class DeductionGroupServiceImpl implements IDeductionGroupService {

    @Autowired
    private DeductionGroupRepository deductionGroupRepository;


    @Override
    public List<DeductionGroup> getAll() {
        return deductionGroupRepository.findAll();
    }

    @Override
    public DeductionGroup get(Long id) throws NotFoundException {
        DeductionGroup deductionGroup = deductionGroupRepository.findOne(id);
        if (Objects.isNull(deductionGroup)) {
            throw new NotFoundException("DeductionGroup Not found with given id : " + id);
        }
        return deductionGroup;
    }

    @Override
    public DeductionGroup save(DeductionGroup deductionGroup) {
        return deductionGroupRepository.save(deductionGroup);
    }

    @Override
    public DeductionGroup update(Long id, DeductionGroup deductionGroup) throws NotFoundException {
        if (!deductionGroupRepository.exists(deductionGroup.getId())) {
            throw new NotFoundException("DeductionGroup Not found with given id : " + deductionGroup.getId());
        }
        return deductionGroupRepository.save(deductionGroup);
    }

    @Override
    public DeductionGroup delete(Long id) throws NotFoundException {
        DeductionGroup deductionGroup = deductionGroupRepository.findOne(id);
        if (!Objects.isNull(deductionGroup)) {
            throw new NotFoundException("DeductionGroup Not found with given id : " + id);
        }
        deductionGroup.setRecordStatus(RecordStatus.INACTIVE);
        return deductionGroupRepository.save(deductionGroup);
    }
}
