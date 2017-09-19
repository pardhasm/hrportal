package com.hrportal.service;

import com.hrportal.model.Attendance;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
public interface IAttendanceService {

    List<Attendance> getAll();

    Attendance get(Long id) throws NotFoundException;

    Attendance save(Attendance attendance);

    Attendance update(Long id, Attendance attendance) throws NotFoundException;

    Attendance delete(Long id) throws NotFoundException;

}
