package com.pz.reservoir.buisness;

import com.pz.reservoir.buisness.dto.Branch;
import com.pz.reservoir.buisness.dto.Firm;
import com.pz.reservoir.party.PartyId;
import com.pz.reservoir.relationship.RelationshipIdentifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BusinessFacadeTest {

    private BusinessFacade businessFacade;

    @BeforeEach
    void setUp() {
        businessFacade = new BusinessFacade(new CompanyInMemoryRepository(),
                new BranchInMemoryRepository(),
                new BranchRelationshipInMemoryRepository()
                );
    }

    @Test
    void addCompany() {
        //given
        var firm = new Firm("EvilCorp", "00000000", "test@test", "www.tst.pl");

        //when
        PartyId partyId = businessFacade.addCompany(firm);

        //then
        assertAll(
                () -> assertNotNull(partyId),
                () -> assertNotNull(businessFacade.getCompany(partyId))
        );

    }

    @Test
    void addUnit() {
        //given
        var firm = new Firm("EvilCorp", "00000000", "test@test", "www.tst.pl");
        PartyId companyId = businessFacade.addCompany(firm);
        var branchDto = new Branch(companyId.getId(), "Gliwice", "000000", "dasdA@dsadas", "www.dsada.pl");

        //when
        RelationshipIdentifier relationshipIdentifier = businessFacade.addBranch(branchDto);

        //then
        assertAll(
                () -> assertNotNull(relationshipIdentifier),
                () -> assertNotNull(businessFacade.getBranchRelationship(relationshipIdentifier)),
                () -> assertNotNull(businessFacade.geBranch(businessFacade.getBranchRelationship(relationshipIdentifier).getClientPartyRole().getParty()))
        );
    }

    @Test
    void addEmployee() {
    }



    @Test
    void addWorkstation() {
    }
}