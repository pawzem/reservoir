package com.pz.reservoir.relationship;

import com.pz.reservoir.party.Company;
import com.pz.reservoir.party.PartyId;
import com.pz.reservoir.party.Person;
import com.pz.reservoir.relationship.relationships.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RelationshipFactory {
    public static VehicleOwnership createOwnershipRelation(PartyId owner, PartyId vehicle){
        var id = RelationshipIdentifier.generate();
        var vehicleOwner = new VehicleOwner(owner, Set.of());
        var ownedVehicle = new Vehicle(vehicle, Set.of());
        return new VehicleOwnership(ownedVehicle, vehicleOwner, id);
    }

    public static CompanyBranch createBranchCompany(PartyId companyId, PartyId branchId){
        var id = RelationshipIdentifier.generate();
        var owner = new BranchOwner(companyId, Set.of());
        var branch = new BranchUnit(branchId, Set.of());
        return new CompanyBranch(branch, owner, id);
    }
}
