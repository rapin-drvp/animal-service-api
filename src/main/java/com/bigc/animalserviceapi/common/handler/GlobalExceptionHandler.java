package com.bigc.animalserviceapi.common.handler;

import com.bigc.animalserviceapi.common.exception.AnimalServiceApiException;
import com.bigc.animalserviceapi.common.exception.AnimalServiceApiInvalidParamException;
import com.bigc.animalserviceapi.common.util.GenericResponse;
import com.bigc.animalserviceapi.common.util.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(AnimalServiceApiException.class)
    public ResponseEntity<GenericResponse> handlerGeneralException(AnimalServiceApiException e){
        log.error("AnimalServiceApiException: {}",e.getStatus().getRemark());
        GenericResponse response = new GenericResponse();
        response.setStatus(ResultCode.SYSTEM_ERROR);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(AnimalServiceApiInvalidParamException.class)
    public ResponseEntity<GenericResponse> handlerGeneralException(AnimalServiceApiInvalidParamException e){
        log.error("AnimalServiceApiInvalidParamException: {}",e.getStatus().getRemark());
        GenericResponse response = new GenericResponse();
        response.setStatus(ResultCode.INVALID_PARAM);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}