package com.pz.reservoir.person;

import com.pz.reservoir.party.PartyId;
import com.pz.reservoir.party.PartyRepository;
import com.pz.reservoir.party.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonInMemoryRepository implements PartyRepository<Person> {

    private final Map<PartyId, Person> personMap = new HashMap<>();

    @Override
    public PartyId save(Person party) {
        personMap.put(party.getPartyId(), party);
        return party.getPartyId();
    }

    @Override
    public Person find(PartyId id) {
        return personMap.get(id);
    }

    @Override
    public List<Person> findAll() {
        return List.copyOf(personMap.values());
    }
}
