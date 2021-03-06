package com.pz.reservoir.organization.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Workstation {
    private final String organizationUnitId;
    private final String workstationId;
    private final String displayName;
}
