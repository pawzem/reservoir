package com.pz.reservoir.buisness;

import com.pz.reservoir.buisness.dto.Firm;
import com.pz.reservoir.party.Company;
import com.pz.reservoir.party.PartyId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BusinessFacadeTest {

    private BusinessFacade businessFacade;

    @BeforeEach
    void setUp() {
        businessFacade = new BusinessFacade(new CompanyInMemoryRepository());
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
    void addEmployee() {
    }

    @Test
    void addUnit() {
    }

    @Test
    void addWorkstation() {
    }
}