package com.hrportal.service.impl;

import com.hrportal.model.EmergencyContact;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.EmergencyContactRepository;
import com.hrportal.service.IEmergencyContactService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
@Service
public class EmergencyContactServiceImpl implements IEmergencyContactService {

    @Autowired
    private EmergencyContactRepository emergencyContactRepository;


    @Override
    public List<EmergencyContact> getAll() {
        return emergencyContactRepository.findAll();
    }

    @Override
    public EmergencyContact get(Long id) throws NotFoundException {
        EmergencyContact emergencyContact = emergencyContactRepository.findOne(id);
        if (Objects.isNull(emergencyContact)) {
            throw new NotFoundException("Emergency Contact Not found with given id : " + id);
        }
        return emergencyContact;
    }

    @Override
    public EmergencyContact save(EmergencyContact emergencyContact) {
        return emergencyContactRepository.save(emergencyContact);
    }

    @Override
    public EmergencyContact update(Long id, EmergencyContact emergencyContact) throws NotFoundException {
        if (!emergencyContactRepository.exists(emergencyContact.getId())) {
            throw new NotFoundException("Emergency Contact Not found with given id : " + emergencyContact.getId());
        }
        return emergencyContactRepository.save(emergencyContact);
    }

    @Override
    public EmergencyContact delete(Long id) throws NotFoundException {
        EmergencyContact emergencyContact = emergencyContactRepository.findOne(id);
        if (!Objects.isNull(emergencyContact)) {
            throw new NotFoundException("Emergency Contact Not found with given id : " + id);
        }
        emergencyContact.setRecordStatus(RecordStatus.INACTIVE);
        return emergencyContactRepository.save(emergencyContact);
    }
}
