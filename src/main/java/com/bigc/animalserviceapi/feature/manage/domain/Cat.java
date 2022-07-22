package com.bigc.animalserviceapi.feature.manage.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cat {
    private String type;
    private String color;
    private String name;
    private String behavior;

    private String origin;

    public Cat(){
        type = "Cat";
        color = "Orange";
        name = "Lego";
        behavior="Friendly";
        origin = "England";
    }
}
