package com.bigc.animalserviceapi.feature.manage.service;

import com.bigc.animalserviceapi.common.util.GenericResponse;
import com.bigc.animalserviceapi.common.util.ResultCode;
import com.bigc.animalserviceapi.feature.manage.domain.Cat;
import com.bigc.animalserviceapi.feature.manage.domain.Dog;
import org.springframework.stereotype.Service;
@Service
public class PetService {

    public GenericResponse getAnimal(String animalType){
        GenericResponse response = new GenericResponse();
        response.setStatus(ResultCode.DATA_NOT_FOUND);
        if(animalType.equals("c")){
            response.setData(new Cat());
            response.setStatus(ResultCode.SUCCESS);
        }
        if(animalType.equals("d")){
            response.setData(new Dog());
            response.setStatus(ResultCode.SUCCESS);
        }
        return response;
    }
}
