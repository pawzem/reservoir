package com.pz.reservoir.client.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ClientDto {
    private final String carId;
    private final String phoneNumber;
    private final CarType carType;
    private final boolean tiresInWarehouse;
    private final ServiceOption serviceOption;
    private final String rimDiameter;
    private final String email;
    private final String firstName;
    private final String lastName;
    //TODO car type, whole wheels/tires,

}
