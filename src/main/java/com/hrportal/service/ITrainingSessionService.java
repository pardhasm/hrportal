package com.hrportal.service;

import com.hrportal.model.TrainingSession;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Pardha Saradhi Mavilla
 */
public interface ITrainingSessionService {

    List<TrainingSession> getAll();

    TrainingSession get(Long id) throws NotFoundException;

    TrainingSession save(TrainingSession user);

    TrainingSession update(Long id, TrainingSession user) throws NotFoundException;

    TrainingSession delete(Long id) throws NotFoundException;
}
