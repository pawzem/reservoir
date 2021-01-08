package com.pz.reservoir.organization;

import com.pz.reservoir.organization.dto.Workstation;
import com.pz.reservoir.party.PartyIdFactory;
import com.pz.reservoir.relationship.RelationshipIdentifier;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
class WorkstationController {

    private final OrganizationFacade organizationFacade;

    @GetMapping(value="api/v1/workstation", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Workstation> getBranches(@RequestParam(name = "branchId") String branchId){
        return organizationFacade.getBranchWorkstations(PartyIdFactory.of(branchId));
    }

    @PostMapping(value = "api/v1/workstation", consumes =  MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    RelationshipIdentifier addBranch(@RequestBody Workstation workstation){
        return organizationFacade.addWorkstation(workstation);
    }
}
