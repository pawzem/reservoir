package com.pz.reservoir.client.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ClientPreferences {
    private final String clientId;
    private final CarType carType;
    private final boolean tiresInWarehouse;
    private final ServiceOption serviceOption;
    private final String rimDiameter;
}
