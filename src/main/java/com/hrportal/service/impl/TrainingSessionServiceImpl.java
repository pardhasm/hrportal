package com.hrportal.service.impl;

import com.hrportal.model.RecordStatus;
import com.hrportal.model.TrainingSession;
import com.hrportal.repository.TrainingSessionRepository;
import com.hrportal.service.ITrainingSessionService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Pardha Saradhi Mavilla
 */
@Service
public class TrainingSessionServiceImpl implements ITrainingSessionService {

    @Autowired
    private TrainingSessionRepository TrainingSessionRepository;


    @Override
    public List<TrainingSession> getAll() {
        return TrainingSessionRepository.findAll();
    }

    @Override
    public TrainingSession get(Long id) throws NotFoundException {
        TrainingSession TrainingSession = TrainingSessionRepository.findOne(id);
        if (Objects.isNull(TrainingSession)) {
            throw new NotFoundException("TrainingSession Not found with given id : " + id);
        }
        return TrainingSession;
    }

    @Override
    public TrainingSession save(TrainingSession TrainingSession) {
        return TrainingSessionRepository.save(TrainingSession);
    }

    @Override
    public TrainingSession update(Long id, TrainingSession TrainingSession) throws NotFoundException {
        if (!TrainingSessionRepository.exists(TrainingSession.getId())) {
            throw new NotFoundException("TrainingSession Not found with given id : " + TrainingSession.getId());
        }
        return TrainingSessionRepository.save(TrainingSession);
    }

    @Override
    public TrainingSession delete(Long id) throws NotFoundException {
        TrainingSession TrainingSession = TrainingSessionRepository.findOne(id);
        if (!Objects.isNull(TrainingSession)) {
            throw new NotFoundException("TrainingSession Not found with given id : " + id);
        }
        TrainingSession.setRecordStatus(RecordStatus.INACTIVE);
        return TrainingSessionRepository.save(TrainingSession);
    }
}
