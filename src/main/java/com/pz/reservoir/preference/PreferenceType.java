package com.pz.reservoir.preference;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@ToString
public class PreferenceType {
    private final PreferenceTypeId id;
    private final String name;
    private final String description;
    private final Set<PreferenceOption> options;

}
