package com.pz.reservoir.party;

import java.util.List;

public interface PartyRepository<P extends Party> {
    PartyId save(P party);
    P find(PartyId id);

    List<P> findAll();
}
