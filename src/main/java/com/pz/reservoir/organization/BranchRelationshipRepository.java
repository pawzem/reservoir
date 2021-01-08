package com.pz.reservoir.organization;

import com.pz.reservoir.organization.dto.Branch;
import com.pz.reservoir.party.PartyId;
import com.pz.reservoir.relationship.PartyRelationShipRepository;
import com.pz.reservoir.relationship.relationships.CompanyBranch;

import java.util.List;

interface BranchRelationshipRepository extends PartyRelationShipRepository<CompanyBranch> {

    List<Branch> findCompanyBranches(PartyId companyId);
}
