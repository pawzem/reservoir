package com.pz.reservoir.person.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ClientPreferences {
    private final String ownerId;
    private final CarType carType;
    private final TireStorage tiresStorage;
    private final ServiceOption serviceOption;
    //TODO rim diameter is preference as it can have multiple values for car, and it's up to client which one he would like to choose
    private final List<String> rimDiameters;
    private final String registrationNumber;
    private final String displayName;
}
