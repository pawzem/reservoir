package com.pz.reservoir.buisness;

import com.pz.reservoir.buisness.dto.Firm;
import com.pz.reservoir.party.*;
import com.pz.reservoir.party.address.TelecomAddress;
import com.pz.reservoir.party.address.WebPageAddress;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class BusinessFacade {

    private final PartyRepository<Company> partyRepository;

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

    public PartyId addEmployee(){
        //TODO
        return null;
    }

    public PartyId addUnit(){
        //TODO
        return null;
    }

    public PartyId addWorkstation(){
        //TODO
        return null;
    }
}
