package com.hrportal.service;

import com.hrportal.model.Setting;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
public interface ISettingService {

    List<Setting> getAll();

    Setting get(Long id) throws NotFoundException;

    Setting save(Setting setting);

    Setting update(Long id, Setting setting) throws NotFoundException;

    Setting delete(Long id) throws NotFoundException;
}
