package com.hrportal.service.impl;

import com.hrportal.model.RecordStatus;
import com.hrportal.model.Setting;
import com.hrportal.repository.SettingRepository;
import com.hrportal.service.ISettingService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
@Service
public class SettingServiceImpl implements ISettingService {

    @Autowired
    private SettingRepository settingRepository;


    @Override
    public List<Setting> getAll() {
        return settingRepository.findAll();
    }

    @Override
    public Setting get(Long id) throws NotFoundException {
        Setting setting = settingRepository.findOne(id);
        if (Objects.isNull(setting)) {
            throw new NotFoundException("Setting Not found with given id : " + id);
        }
        return setting;
    }

    @Override
    public Setting save(Setting setting) {
        return settingRepository.save(setting);
    }

    @Override
    public Setting update(Long id, Setting setting) throws NotFoundException {
        if (!settingRepository.exists(setting.getId())) {
            throw new NotFoundException("Setting Not found with given id : " + setting.getId());
        }
        return settingRepository.save(setting);
    }

    @Override
    public Setting delete(Long id) throws NotFoundException {
        Setting setting = settingRepository.findOne(id);
        if (!Objects.isNull(setting)) {
            throw new NotFoundException("Setting Not found with given id : " + id);
        }
        setting.setRecordStatus(RecordStatus.INACTIVE);
        return settingRepository.save(setting);
    }
}
