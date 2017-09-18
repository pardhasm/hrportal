package com.hrportal.controller;

import com.hrportal.model.User;
import com.hrportal.service.IUserService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private IUserService userService;

    @RequestMapping(value="/",method=RequestMethod.GET)
    public ResponseEntity getAllUsers() {
        return ResponseEntity.ok(userService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getUserDetails(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(userService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public User insertUser(@RequestBody User user) {
        return userService.save(user);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> UpdateUser(@PathVariable("id") Long id, @RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.update(id, user));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> DeleteUser(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(userService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}