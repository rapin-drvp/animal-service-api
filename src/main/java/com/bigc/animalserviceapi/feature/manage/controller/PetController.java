package com.bigc.animalserviceapi.feature.manage.controller;

import com.bigc.animalserviceapi.common.exception.AnimalServiceApiException;
import com.bigc.animalserviceapi.common.util.GenericResponse;
import com.bigc.animalserviceapi.feature.manage.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Parameter;

@RestController
@RequestMapping("v1/manage")
public class PetController {
    @Autowired
    private PetService manageService;
    @GetMapping
    public ResponseEntity<GenericResponse> getAnimal(@RequestHeader (name = "X-Correlation-Id") String correlationId) throws AnimalServiceApiException {
        GenericResponse response = manageService.getAnimal("c");
        ResponseEntity<GenericResponse> responseEntity = ResponseEntity.status(HttpStatus.OK).body(response);
        return  responseEntity;
    }
    @GetMapping("/{type}")
    public ResponseEntity<GenericResponse> getAnimal(@RequestHeader (name = "X-Correlation-Id") String correlationId,
                                                     @PathVariable String type) throws AnimalServiceApiException {
        GenericResponse response = manageService.getAnimal(type);
        ResponseEntity<GenericResponse> responseEntity = ResponseEntity.status(HttpStatus.OK).body(response);
        return  responseEntity;
    }
    @PostMapping
    public ResponseEntity<GenericResponse> persist(@RequestHeader (name = "X-Correlation-Id") String correlationId){
        GenericResponse response = manageService.persistData();
        ResponseEntity<GenericResponse> responseEntity = ResponseEntity.status(HttpStatus.OK).body(response);
        return  responseEntity;
    }
    @PutMapping
    public ResponseEntity<GenericResponse> update(@RequestHeader (name = "X-Correlation-Id") String correlationId){
        GenericResponse response = manageService.updateData();
        ResponseEntity<GenericResponse> responseEntity = ResponseEntity.status(HttpStatus.OK).body(response);
        return  responseEntity;
    }
    @PutMapping("/update")
    public ResponseEntity<GenericResponse> update(@RequestHeader (name = "X-Correlation-Id") String correlationId,
     @RequestParam(name = "cat") String updateCat){
        GenericResponse response = manageService.updateData(updateCat);
        ResponseEntity<GenericResponse> responseEntity = ResponseEntity.status(HttpStatus.OK).body(response);
        return  responseEntity;
    }
}