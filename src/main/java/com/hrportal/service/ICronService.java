package com.hrportal.service;

import com.hrportal.model.Cron;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
public interface ICronService {

    List<Cron> getAll();

    Cron get(Long id) throws NotFoundException;

    Cron save(Cron cron);

    Cron update(Long id, Cron cron) throws NotFoundException;

    Cron delete(Long id) throws NotFoundException;
}

