package com.pz.reservoir.preference;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class MissingOptionInPreferenceType extends RuntimeException {
    public MissingOptionInPreferenceType(PreferenceType type, PreferenceOption option) {
        super(String.format("Option '%s' not present in type '%s'", option, type.getName()));

    }
}
