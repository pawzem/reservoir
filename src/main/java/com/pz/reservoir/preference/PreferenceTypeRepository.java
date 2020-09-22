package com.pz.reservoir.preference;

public interface PreferenceTypeRepository {
    PreferenceTypeId save(PreferenceType type);
    PreferenceType find(PreferenceTypeId id);
}
