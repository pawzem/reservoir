package com.pz.reservoir.organization;

import com.pz.reservoir.organization.dto.Branch;
import com.pz.reservoir.organization.dto.Firm;
import com.pz.reservoir.organization.dto.Workstation;
import com.pz.reservoir.party.PartyId;
import com.pz.reservoir.relationship.RelationshipIdentifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OrganizationFacadeTest {

    private OrganizationFacade organizationFacade;

    @BeforeEach
    void setUp() {
        organizationFacade = new OrganizationFacade(new CompanyInMemoryRepository(),
                new BranchInMemoryRepository(),
                new BranchRelationshipInMemoryRepository(),
                new WorkstationRelationshipInMemoryRepository()
                );
    }

    @Test
    void addCompany() {
        //given
        var firm = new Firm("EvilCorp", "00000000", "test@test", "www.tst.pl");

        //when
        PartyId partyId = organizationFacade.addCompany(firm);

        //then
        assertAll(
                () -> assertNotNull(partyId),
                () -> assertNotNull(organizationFacade.getCompany(partyId))
        );

    }

    @Test
    void addUnit() {
        //given
        var firm = new Firm("EvilCorp", "00000000", "test@test", "www.tst.pl");
        PartyId companyId = organizationFacade.addCompany(firm);
        var branchDto = new Branch(companyId.getId(), "Gliwice", "000000", "dasdA@dsadas", "www.dsada.pl");

        //when
        RelationshipIdentifier relationshipIdentifier = organizationFacade.addBranch(branchDto);

        //then
        assertAll(
                () -> assertNotNull(relationshipIdentifier),
                () -> assertNotNull(organizationFacade.getBranchRelationship(relationshipIdentifier)),
                () -> assertNotNull(organizationFacade.geBranch(organizationFacade.getBranchRelationship(relationshipIdentifier).getClientPartyRole().getParty()))
        );
    }

    @Test
    void addWorkstations() {
        //given
        var firm = new Firm("EvilCorp", "00000000", "test@test", "www.tst.pl");
        PartyId companyId = organizationFacade.addCompany(firm);
        var branchDto = new Branch(companyId.getId(), "Gliwice", "000000", "dasdA@dsadas", "www.dsada.pl");
        RelationshipIdentifier relationshipIdentifier = organizationFacade.addBranch(branchDto);

        Workstation firstWorkstationDto = new Workstation(branchDto.getOrganizationId(),"workstation1");

        //when

        RelationshipIdentifier firstWorkstationRelationshipIdentifier = organizationFacade.addWorkstation(firstWorkstationDto);

        //then
        assertAll(
                () -> assertNotNull(firstWorkstationRelationshipIdentifier),
                () -> assertNotNull(organizationFacade.getWorkstationRelationship(firstWorkstationRelationshipIdentifier)),
                () -> assertNotNull(organizationFacade.getWorkStation(organizationFacade.getWorkstationRelationship(firstWorkstationRelationshipIdentifier).getClientPartyRole().getParty()))
        );
    }


}