package com.pz.reservoir.preference;

import java.util.Optional;

public  class PreferenceFactory {
    public static Preference generate(PreferenceType type, String option){
        Optional<PreferenceOption> preferenceOption = type.getOptions().stream().filter(o -> o.getName().equals(option)).findAny();
        return new Preference(preferenceOption.orElseThrow(() -> new MissingOptionInPreferenceType(type, option)), type.getId());
    }
}
