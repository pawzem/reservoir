package com.pz.reservoir.preference;

public class Preference {
    private final PreferenceOption option;
    private final PreferenceTypeId typeId;

    Preference(PreferenceOption option, PreferenceTypeId typeId){
        this.option = option;
        this.typeId = typeId;
    }

    public String getOptionName(){
        return option.getName();
    };
    public String getOptionDescription(){
        return option.getName();
    };
    public PreferenceTypeId getPreferenceType(){
        return typeId;
    };
}
