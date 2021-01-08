package com.pz.reservoir.organization;

import com.pz.reservoir.organization.dto.Workstation;
import com.pz.reservoir.party.PartyId;
import com.pz.reservoir.relationship.PartyRelationShipRepository;
import com.pz.reservoir.relationship.relationships.WorkstationOwnership;

import java.util.List;

interface WorkstationRelationshipRepository extends PartyRelationShipRepository<WorkstationOwnership> {
    List<Workstation> findBranchWorksations(PartyId branchId);
}
