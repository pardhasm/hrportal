package com.hrportal.service.impl;

import com.hrportal.model.Cron;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.CronRepository;
import com.hrportal.service.ICronService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
@Service
public class CronServiceImpl implements ICronService {

    @Autowired
    private CronRepository cronRepository;


    @Override
    public List<Cron> getAll() {
        return cronRepository.findAll();
    }

    @Override
    public Cron get(Long id) throws NotFoundException {
        Cron cron = cronRepository.findOne(id);
        if (Objects.isNull(cron)) {
            throw new NotFoundException("Cron Not found with given id : " + id);
        }
        return cron;
    }

    @Override
    public Cron save(Cron cron) {
        return cronRepository.save(cron);
    }

    @Override
    public Cron update(Long id, Cron cron) throws NotFoundException {
        if (!cronRepository.exists(cron.getId())) {
            throw new NotFoundException("Cron Not found with given id : " + cron.getId());
        }
        return cronRepository.save(cron);
    }

    @Override
    public Cron delete(Long id) throws NotFoundException {
        Cron cron = cronRepository.findOne(id);
        if (!Objects.isNull(cron)) {
            throw new NotFoundException("Cron Not found with given id : " + id);
        }
        cron.setRecordStatus(RecordStatus.INACTIVE);
        return cronRepository.save(cron);
    }

}
