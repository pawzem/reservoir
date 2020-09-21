package com.pz.reservoir.party.address;

import com.pz.reservoir.party.Address;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WebPageAddress extends Address {

    private final String url;

    @Override
    public String getAddress() {
        return url;
    }
}
