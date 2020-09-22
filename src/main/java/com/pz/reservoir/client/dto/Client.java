package com.pz.reservoir.client.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
public class Client {
    @NotNull
    private final String phoneNumber;
    private final String email;
    private final String firstName;
    private final String lastName;
    //TODO car type, whole wheels/tires,

}
