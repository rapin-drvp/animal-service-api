package com.bigc.animalserviceapi.feature.manage.controller;

import com.bigc.animalserviceapi.common.util.GenericResponse;
import com.bigc.animalserviceapi.feature.manage.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/manage")
public class PetController {

    @Autowired
    private PetService petService;
    @GetMapping("/{type}")
    public ResponseEntity<GenericResponse> getAnimal(@RequestHeader (name = "X-Correlation-Id") String correlationId,
                                                     @PathVariable String type){
        GenericResponse response = petService.getAnimal(type);
        ResponseEntity<GenericResponse> responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        return  responseEntity;
    }
}
