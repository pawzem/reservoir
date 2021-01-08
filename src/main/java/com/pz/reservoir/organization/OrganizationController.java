package com.pz.reservoir.organization;

import com.pz.reservoir.organization.dto.Firm;
import com.pz.reservoir.party.PartyId;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
class OrganizationController {

    private final OrganizationFacade organizationFacade;

    @GetMapping(value="api/v1/organization", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Firm> getFirms(){
        return organizationFacade.getCompanies();
    }

    @PostMapping(value = "api/v1/organization", consumes =  MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    PartyId addFirm(@RequestBody Firm firm){
        return organizationFacade.addCompany(firm);
    }


}
