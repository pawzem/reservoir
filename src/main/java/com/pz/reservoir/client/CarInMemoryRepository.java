package com.pz.reservoir.client;

import com.pz.reservoir.party.Car;
import com.pz.reservoir.party.PartyId;
import com.pz.reservoir.party.PartyRepository;

import java.util.HashMap;
import java.util.Map;

public class CarInMemoryRepository implements PartyRepository<Car> {

    private Map<PartyId, Car> cars = new HashMap<>();

    @Override
    public PartyId save(Car party) {
        cars.put(party.getPartyId(), party);
        return party.getPartyId();
    }

    @Override
    public Car find(PartyId id) {
        return cars.get(id);
    }
}