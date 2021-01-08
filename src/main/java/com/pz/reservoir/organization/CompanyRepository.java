package com.pz.reservoir.organization;

import com.pz.reservoir.organization.dto.Firm;
import com.pz.reservoir.party.Company;
import com.pz.reservoir.party.PartyRepository;

import java.util.List;

interface CompanyRepository extends PartyRepository<Company>  {
    List<Firm> findAllFirms();
}
