package com.pz.reservoir.client;

import com.pz.reservoir.party.PartyId;
import com.pz.reservoir.party.PartyRepository;
import com.pz.reservoir.party.Person;

import java.util.HashMap;
import java.util.Map;

public class ClientInMemoryRepository implements PartyRepository<Person> {

    private Map<PartyId, Person> personMap = new HashMap<>();

    @Override
    public PartyId save(Person party) {
        personMap.put(party.getPartyId(), party);
        return party.getPartyId();
    }

    @Override
    public Person find(PartyId id) {
        return personMap.get(id);
    }
}
