package com.pz.reservoir.buisness.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Branch {
    private final String organizationId;
    private final String displayName;
    private final String phoneNumber;
    private final String email;
    private final String website;

}
