package com.pz.reservoir.buisness.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FirmUnit {
    private final String organizationId;
    private final String displayName;
    private final String phoneNumber;
    private final String website;

}
