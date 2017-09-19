package com.hrportal.controller;

import com.hrportal.model.DataImportFile;
import com.hrportal.service.IDataImportFileService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
@RestController
@RequestMapping("/dataImportFile")
public class DataImportFileController {

    private IDataImportFileService dataImportFileService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(dataImportFileService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(dataImportFileService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public DataImportFile insert(@RequestBody DataImportFile dataImportFile) {
        return dataImportFileService.save(dataImportFile);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<DataImportFile> update(@PathVariable("id") Long id, @RequestBody DataImportFile dataImportFile) {
        try {
            return ResponseEntity.ok(dataImportFileService.update(id, dataImportFile));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DataImportFile> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(dataImportFileService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
