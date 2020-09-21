package com.pz.reservoir.preference;

public class PreferenceFactory {
    Preference generate(PreferenceType type, PreferenceOption option){
        if(type.getOptions().contains(option)){
            return new Preference(option, type.getId());
        } else throw new MissingOptionInPreferenceType(type, option);
    }
}
