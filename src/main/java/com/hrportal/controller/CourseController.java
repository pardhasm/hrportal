package com.hrportal.controller;

import com.hrportal.model.Course;
import com.hrportal.service.ICourseService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    private ICourseService courseService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(courseService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(courseService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Course insert(@RequestBody Course course) {
        return courseService.save(course);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Course> update(@PathVariable("id") Long id, @RequestBody Course course) {
        try {
            return ResponseEntity.ok(courseService.update(id, course));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Course> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(courseService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}
