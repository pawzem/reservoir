package com.pz.reservoir.buisness;

import com.pz.reservoir.buisness.dto.Firm;
import com.pz.reservoir.buisness.dto.Branch;
import com.pz.reservoir.party.*;
import com.pz.reservoir.party.address.TelecomAddress;
import com.pz.reservoir.party.address.WebPageAddress;
import com.pz.reservoir.relationship.PartyRelationShipRepository;
import com.pz.reservoir.relationship.RelationshipFactory;
import com.pz.reservoir.relationship.RelationshipIdentifier;
import com.pz.reservoir.relationship.relationships.CompanyBranch;
import com.pz.reservoir.relationship.relationships.VehicleOwnership;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class BusinessFacade {

    private final PartyRepository<Company> partyRepository;
    private final PartyRepository<OrganizationUnit> branchRepository;
    private final PartyRelationShipRepository<CompanyBranch> branchRelationshipRepository;

    public PartyId addCompany(Firm firmDto){
        var telecomAddress = new TelecomAddress(firmDto.getPhoneNumber());
        var webAddress = new WebPageAddress(firmDto.getWebsite());
        var email = new WebPageAddress(firmDto.getEmail());
        List<Address> addresses = List.of(telecomAddress, webAddress, email);


        var  company = PartyFactory.createCompany(firmDto.getDisplayName(), addresses, List.of(), Set.of());

        return partyRepository.save(company);
    }

    public Company getCompany(PartyId id){
        return partyRepository.find(id);
    }

    public OrganizationUnit geBranch(PartyId branchId){
        return branchRepository.find(branchId);
    }

    public CompanyBranch getBranchRelationship(RelationshipIdentifier branchRelationshipId){
        return branchRelationshipRepository.find(branchRelationshipId);
    }

    public RelationshipIdentifier addBranch(Branch branchDto){
        PartyId branchId = createBranch(branchDto);

        var branchRelationship = RelationshipFactory.createBranchCompany(PartyIdFactory.of(branchDto.getOrganizationId()), branchId);

        return branchRelationshipRepository.save(branchRelationship);
    }

    private PartyId createBranch(Branch branchDto) {
        var telecomAddress = new TelecomAddress(branchDto.getPhoneNumber());
        var webAddress = new WebPageAddress(branchDto.getWebsite());
        var email = new WebPageAddress(branchDto.getEmail());
        List<Address> addresses = List.of(telecomAddress, webAddress, email);


        var  branch = PartyFactory.createUnit(branchDto.getDisplayName(), addresses, List.of(), Set.of());

        return branchRepository.save(branch);
    }

    public PartyId addWorkstation(){
        //TODO
        return null;
    }

    public PartyId addEmployee(){
        //TODO
        return null;
    }
}
