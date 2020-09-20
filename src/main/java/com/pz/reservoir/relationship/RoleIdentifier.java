package com.pz.reservoir.relationship;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@EqualsAndHashCode
public class RoleIdentifier {
    private final String id;

    @Override
    public String toString() {
        return id;
    }

}
