package com.pz.reservoir.client.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ClientPreferences {
    private final String ownerId;
    private final CarType carType;
    private final TireStorage tiresStorage;
    private final ServiceOption serviceOption;
    private final String rimDiameter;
    private final String registrationNumber;
    private final String displayName;
}
