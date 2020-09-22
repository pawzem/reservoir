package com.pz.reservoir.preference;

import java.util.HashMap;
import java.util.Map;

public class PreferenceTypeInMemoryRepository implements PreferenceTypeRepository {

    private Map<PreferenceTypeId, PreferenceType> preferences = new HashMap<>();

    @Override
    public PreferenceTypeId save(PreferenceType type) {
        preferences.put(type.getId(), type);
        return type.getId();
    }

    @Override
    public PreferenceType find(PreferenceTypeId id) {
        return preferences.get(id);
    }
}
