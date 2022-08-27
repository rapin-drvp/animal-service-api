package com.bigc.animalserviceapi.feature.manage.service;

import com.bigc.animalserviceapi.common.exception.AnimalServiceApiException;
import com.bigc.animalserviceapi.common.exception.AnimalServiceApiInvalidParamException;
import com.bigc.animalserviceapi.common.util.GenericResponse;
import com.bigc.animalserviceapi.common.util.ResultCode;
import com.bigc.animalserviceapi.common.util.Status;
import com.bigc.animalserviceapi.feature.manage.domain.Cat;
import com.bigc.animalserviceapi.feature.manage.domain.Dog;
import org.springframework.stereotype.Service;
@Service
public class PetService {

    public GenericResponse getAnimal(String animalType) throws AnimalServiceApiException {
        /*
        homework request http://localhost:8885/animal-service-api/v1/manage/h
        1.create custom exception Data Not Found
        2.find data from HashMap if not found throws Data Not Found Exception
         */
        validParam(animalType);
        GenericResponse response = new GenericResponse();
        if(animalType.equals("c")){
            response.setData(new Cat());
        }
        if(animalType.equals("d")){
            response.setData(new Dog());
        }
        response.setStatus(ResultCode.SUCCESS);
        return response;
    }
    private void validParam(String animalType) throws AnimalServiceApiException {
        if (! animalType.equals("c") && ! animalType.equals("d"))
            throw new AnimalServiceApiInvalidParamException(ResultCode.INVALID_PARAM, "Animal type not allow.");
    }
    public GenericResponse  persistData(){
        GenericResponse response = new GenericResponse();
        response.setStatus(new Status(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),"Save data is done."));
        return response;
    }
    public GenericResponse updateData(){
        GenericResponse response = new GenericResponse();
        response.setStatus(new Status(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),"Update data is done."));
        return response;
    }

    public GenericResponse updateData(String update){
        GenericResponse response = new GenericResponse();
        response.setStatus(new Status(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),"Update data is "+update+" done."));
        return response;
    }
}