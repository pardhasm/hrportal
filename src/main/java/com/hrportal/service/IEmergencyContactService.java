package com.hrportal.service;

import com.hrportal.model.EmergencyContact;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
public interface IEmergencyContactService {

    List<EmergencyContact> getAll();

    EmergencyContact get(Long id) throws NotFoundException;

    EmergencyContact save(EmergencyContact emergencyContact);

    EmergencyContact update(Long id, EmergencyContact emergencyContact) throws NotFoundException;

    EmergencyContact delete(Long id) throws NotFoundException;
}
