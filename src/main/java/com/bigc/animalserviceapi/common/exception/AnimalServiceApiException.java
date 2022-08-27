package com.bigc.animalserviceapi.common.exception;

import com.bigc.animalserviceapi.common.util.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimalServiceApiException extends Exception{
    private Status status;

    public AnimalServiceApiException(Status status){
        this.status = status;
    }
    public AnimalServiceApiException(Status status, String customMessage){
        super(customMessage);
        status.setRemark(customMessage);
        this.status = status;
    }
}
