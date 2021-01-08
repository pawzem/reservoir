package com.pz.reservoir.organization;

import com.pz.reservoir.organization.dto.Branch;
import com.pz.reservoir.organization.dto.Workstation;
import com.pz.reservoir.party.Address;
import com.pz.reservoir.party.OrganizationUnit;
import com.pz.reservoir.party.PartyId;
import com.pz.reservoir.party.PartyRepository;
import com.pz.reservoir.party.address.EmailAddress;
import com.pz.reservoir.party.address.TelecomAddress;
import com.pz.reservoir.party.address.WebPageAddress;
import com.pz.reservoir.relationship.PartyRelationShipRepository;
import com.pz.reservoir.relationship.RelationshipIdentifier;
import com.pz.reservoir.relationship.relationships.CompanyBranch;
import com.pz.reservoir.relationship.relationships.WorkstationOwnership;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class WorkstationRelationshipInMemoryRepository implements WorkstationRelationshipRepository {

    private final Map<RelationshipIdentifier, WorkstationOwnership> workstationRelationships = new HashMap<>();
    private final PartyRepository<OrganizationUnit> workstationRepository;

    @Override
    public RelationshipIdentifier save(WorkstationOwnership relationship) {
        workstationRelationships.put(relationship.getRelationshipIdentifier(), relationship);
        return relationship.getRelationshipIdentifier();
    }

    @Override
    public WorkstationOwnership find(RelationshipIdentifier relationship) {
        return workstationRelationships.get(relationship);
    }

    @Override
    public List<WorkstationOwnership> findBySupplierId(PartyId partyId) {
        return workstationRelationships.values()
                .stream()
                .filter(relationship -> Objects.equals(relationship.getSupplierPartyRole().getParty(), partyId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Workstation> findBranchWorksations(PartyId branchId) {
        return findBySupplierId(branchId).stream()
                .map(relationship -> relationship.getClientPartyRole().getParty())
                .map(workstationRepository::find)
                .map(organizationUnit -> new Workstation(branchId.getId(), organizationUnit.getPartyId().getId(), organizationUnit.getName()))
                .collect(Collectors.toList());
    }
}
