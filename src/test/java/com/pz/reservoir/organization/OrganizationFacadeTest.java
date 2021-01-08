package com.pz.reservoir.organization;

import com.pz.reservoir.organization.dto.Branch;
import com.pz.reservoir.organization.dto.Firm;
import com.pz.reservoir.organization.dto.Workstation;
import com.pz.reservoir.party.PartyId;
import com.pz.reservoir.relationship.RelationshipIdentifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrganizationFacadeTest {

    private OrganizationFacade organizationFacade;

    @BeforeEach
    void setUp() {
        var organizationUnitRepository = new BranchInMemoryRepository();
        organizationFacade = new OrganizationFacade(new CompanyInMemoryRepository(),
                organizationUnitRepository,
                new BranchRelationshipInMemoryRepository(organizationUnitRepository),
                new WorkstationRelationshipInMemoryRepository()
                );
    }

    @Test
    void shouldAddCompany() {
        //given
        var firm = new Firm(null,"EvilCorp", "00000000", "test@test", "www.tst.pl");

        //when
        PartyId partyId = organizationFacade.addCompany(firm);

        //then
        assertAll(
                () -> assertNotNull(partyId),
                () -> assertNotNull(organizationFacade.getCompany(partyId))
        );

    }

    @Test
    void shouldReturnCompanies() {
        //given
        var firm = new Firm(null,"EvilCorp", "00000000", "test@test", "www.tst.pl");
        PartyId partyId = organizationFacade.addCompany(firm);

        //when
        List<Firm> companies = organizationFacade.getCompanies();

        //then
        assertAll(
                () -> assertEquals(1, companies.size()),
                () -> assertEquals(partyId.getId(), companies.get(0).getId())
        );

    }

    @Test
    void shouldAddBranch() {
        //given
        var firm = new Firm(null,"EvilCorp", "00000000", "test@test", "www.tst.pl");
        PartyId companyId = organizationFacade.addCompany(firm);
        var branchDto = new Branch(companyId.getId(), null, "Gliwice", "000000", "dasdA@dsadas", "www.dsada.pl");

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
    void shouldReturnCompanyBranches() {
        //given
        var firm = new Firm(null,"EvilCorp", "00000000", "test@test", "www.tst.pl");
        PartyId companyId = organizationFacade.addCompany(firm);
        var branchDto = new Branch(companyId.getId(), null, "Gliwice", "000000", "dasdA@dsadas", "www.dsada.pl");
        RelationshipIdentifier relationshipIdentifier = organizationFacade.addBranch(branchDto);

        //when
        List<Branch> companyBranches = organizationFacade.getCompanyBranches(companyId);


        //then
        assertAll(
                () -> assertEquals(1, companyBranches.size()),
                () -> assertEquals(companyBranches.get(0).getDisplayName(), branchDto.getDisplayName())
        );
    }

    @Test
    void shouldAddWorkstations() {
        //given
        var firm = new Firm(null,"EvilCorp", "00000000", "test@test", "www.tst.pl");
        PartyId companyId = organizationFacade.addCompany(firm);
        var branchDto = new Branch(companyId.getId(), null, "Gliwice", "000000", "dasdA@dsadas", "www.dsada.pl");
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