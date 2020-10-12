package com.pz.reservoir.buisness.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Firm {
    private final String displayName;
    private final String phoneNumber;
    private final String email;
    private final String website;

}
