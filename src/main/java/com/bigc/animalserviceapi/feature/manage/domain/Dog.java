package com.bigc.animalserviceapi.feature.manage.domain;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Dog {
    private String type;
    private String color;
    private String name;
    private String species;
    private String behavior;

    public Dog(){
        type="Dog";
        color="ฺBlack";
        name="Love";
        species="Doberman";
        behavior="Enthusiastic";
    }
}
