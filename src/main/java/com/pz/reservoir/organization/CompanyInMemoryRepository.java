package com.pz.reservoir.organization;

import com.pz.reservoir.organization.dto.Firm;
import com.pz.reservoir.party.Address;
import com.pz.reservoir.party.Company;
import com.pz.reservoir.party.PartyId;
import com.pz.reservoir.party.address.EmailAddress;
import com.pz.reservoir.party.address.TelecomAddress;
import com.pz.reservoir.party.address.WebPageAddress;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CompanyInMemoryRepository implements CompanyRepository {

    private final Map<PartyId, Company> organizationMap = new HashMap<>();

    @Override
    public PartyId save(Company party) {
        organizationMap.put(party.getPartyId(), party);
        return party.getPartyId();
    }

    @Override
    public Company find(PartyId id) {
        return organizationMap.get(id);
    }

    @Override
    public List<Company> findAll() {
        return List.copyOf(organizationMap.values());
    }

    @Override
    public List<Firm> findAllFirms() {
        return this.findAll()
                .stream()
                .map(company -> {
                    company.getAddresses();
                    var addresses = company.getAddresses();
                    var phoneNumber = addresses.stream().filter(address -> address instanceof TelecomAddress).findAny().map(Address::getAddress).orElse("");
                    var webAddress = addresses.stream().filter(address -> address instanceof WebPageAddress).findAny().map(Address::getAddress).orElse("");
                    var email = addresses.stream().filter(address -> address instanceof EmailAddress).findAny().map(Address::getAddress).orElse("");
                    return new Firm(company.getPartyId().getId(), company.getOrganizationName().getName(), phoneNumber,email,webAddress);
                })
                .collect(Collectors.toList());
    }
}
