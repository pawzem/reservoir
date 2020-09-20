package com.pz.reservoir.party;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@EqualsAndHashCode
public class PartyId {
    private final String id;

    @Override
    public String toString() {
        return id;
    }

}
