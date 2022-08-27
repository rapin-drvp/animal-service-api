package com.bigc.animalserviceapi.common.exception;

import com.bigc.animalserviceapi.common.util.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimalServiceApiInvalidParamException extends AnimalServiceApiException{

    public AnimalServiceApiInvalidParamException(Status status) {
        super(status);
    }

    public AnimalServiceApiInvalidParamException(Status status, String customMessage) {
        super(status, customMessage);
    }
}
