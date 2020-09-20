package com.pz.reservoir.party;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrganizationName {
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
