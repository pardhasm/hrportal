package com.hrportal.service.impl;

import com.hrportal.model.Attendance;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.AttendanceRepository;
import com.hrportal.service.IAttendanceService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
@Service
public class AttendanceServiceImpl implements IAttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;


    @Override
    public List<Attendance> getAll() {
        return attendanceRepository.findAll();
    }

    @Override
    public Attendance get(Long id) throws NotFoundException {
        Attendance attendance = attendanceRepository.findOne(id);
        if (Objects.isNull(attendance)) {
            throw new NotFoundException("Attendance Not found with given id : " + id);
        }
        return attendance;
    }

    @Override
    public Attendance save(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public Attendance update(Long id, Attendance attendance) throws NotFoundException {
        if (!attendanceRepository.exists(attendance.getId())) {
            throw new NotFoundException("Attendance Not found with given id : " + attendance.getId());
        }
        return attendanceRepository.save(attendance);
    }

    @Override
    public Attendance delete(Long id) throws NotFoundException {
        Attendance attendance = attendanceRepository.findOne(id);
        if (!Objects.isNull(attendance)) {
            throw new NotFoundException("Attendance Not found with given id : " + id);
        }
        attendance.setRecordStatus(RecordStatus.INACTIVE);
        return attendanceRepository.save(attendance);
    }


}
