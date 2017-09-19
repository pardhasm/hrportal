package com.hrportal.service;

import com.hrportal.model.Course;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
public interface ICourseService {

    List<Course> getAll();

    Course get(Long id) throws NotFoundException;

    Course save(Course course);

    Course update(Long id, Course course) throws NotFoundException;

    Course delete(Long id) throws NotFoundException;

}
