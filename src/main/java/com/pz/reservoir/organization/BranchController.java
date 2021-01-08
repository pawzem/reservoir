package com.pz.reservoir.organization;

import com.pz.reservoir.organization.dto.Branch;
import com.pz.reservoir.party.PartyIdFactory;
import com.pz.reservoir.relationship.RelationshipIdentifier;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
class BranchController {

    private final OrganizationFacade organizationFacade;

    @GetMapping(value="api/v1/branch", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Branch> getBranches(@RequestParam(name = "companyId") String companyId){
        return organizationFacade.getCompanyBranches(PartyIdFactory.of(companyId));
    }

    @PostMapping(value = "api/v1/branch", consumes =  MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    RelationshipIdentifier addBranch(@RequestBody Branch branch){
        return organizationFacade.addBranch(branch);
    }
}
