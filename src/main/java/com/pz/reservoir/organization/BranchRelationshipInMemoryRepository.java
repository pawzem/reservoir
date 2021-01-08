package com.pz.reservoir.organization;

import com.pz.reservoir.organization.dto.Branch;
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
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class BranchRelationshipInMemoryRepository implements BranchRelationshipRepository {

    private final Map<RelationshipIdentifier, CompanyBranch> relationshipBranch = new HashMap<>();
    private final PartyRepository<OrganizationUnit> branchRepository;

    @Override
    public RelationshipIdentifier save(CompanyBranch relationship) {
        relationshipBranch.put(relationship.getRelationshipIdentifier(), relationship);
        return relationship.getRelationshipIdentifier();
    }

    @Override
    public CompanyBranch find(RelationshipIdentifier relationship) {
        return relationshipBranch.get(relationship);
    }

    @Override
    public List<CompanyBranch> findBySupplierId(PartyId partyId) {
        return relationshipBranch.values()
                .stream()
                .filter(relationship -> Objects.equals(relationship.getSupplierPartyRole().getParty(), partyId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Branch> findCompanyBranches(PartyId companyId) {
        return findBySupplierId(companyId).stream()
                .map(relationship -> relationship.getClientPartyRole().getParty())
                .map(branchRepository::find)
                .map(organizationUnit -> {
                    var addresses = organizationUnit.getAddresses();
                    var phoneNumber = addresses.stream().filter(address -> address instanceof TelecomAddress).findAny().map(Address::getAddress).orElse("");
                    var webAddress = addresses.stream().filter(address -> address instanceof WebPageAddress).findAny().map(Address::getAddress).orElse("");
                    var email = addresses.stream().filter(address -> address instanceof EmailAddress).findAny().map(Address::getAddress).orElse("");

                    return new Branch(companyId.getId(),
                            organizationUnit.getPartyId().getId(),
                            organizationUnit.getName(),
                            phoneNumber,
                            email,
                            webAddress);
                })
                .collect(Collectors.toList());
    }
}
