package com.hrportal.service.impl;

import com.hrportal.model.Course;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.CourseRepository;
import com.hrportal.service.ICourseService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;


    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course get(Long id) throws NotFoundException {
        Course course = courseRepository.findOne(id);
        if (Objects.isNull(course)) {
            throw new NotFoundException("Course Not found with given id : " + id);
        }
        return course;
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course update(Long id, Course course) throws NotFoundException {
        if (!courseRepository.exists(course.getId())) {
            throw new NotFoundException("Course Not found with given id : " + course.getId());
        }
        return courseRepository.save(course);
    }

    @Override
    public Course delete(Long id) throws NotFoundException {
        Course course = courseRepository.findOne(id);
        if (!Objects.isNull(course)) {
            throw new NotFoundException("Course Not found with given id : " + id);
        }
        course.setRecordStatus(RecordStatus.INACTIVE);
        return courseRepository.save(course);
    }

}
