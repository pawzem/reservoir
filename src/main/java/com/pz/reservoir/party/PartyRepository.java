package com.pz.reservoir.party;

public interface PartyRepository<P extends Party> {
    PartyId save(P party);
    P find(PartyId id);
}
