package com.pz.reservoir.organization;

import com.pz.reservoir.party.Company;
import com.pz.reservoir.party.OrganizationUnit;
import com.pz.reservoir.party.PartyRepository;
import com.pz.reservoir.relationship.PartyRelationShipRepository;
import com.pz.reservoir.relationship.relationships.CompanyBranch;
import com.pz.reservoir.relationship.relationships.WorkstationOwnership;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
class OrganizationConfiguration {

    @Bean
    OrganizationFacade companyFacade(CompanyRepository companyRepository,
                                     PartyRepository<OrganizationUnit> branchRepository,
                                     BranchRelationshipRepository branchRelationshipRepository,
                                     PartyRelationShipRepository<WorkstationOwnership> workstationOwnershipPartyRelationShipRepository){
        return new OrganizationFacade(companyRepository,
                branchRepository,
                branchRelationshipRepository,
                workstationOwnershipPartyRelationShipRepository
                );
    }

    @Bean
    @Profile("InMemoryRepository")
    CompanyRepository companyRepository(){
        return new CompanyInMemoryRepository();
    }

    @Bean
    @Profile("InMemoryRepository")
    PartyRepository<OrganizationUnit> branchRepository(){
        return new BranchInMemoryRepository();
    }

    @Bean
    @Profile("InMemoryRepository")
    BranchRelationshipRepository branchRelationshipRepository(PartyRepository<OrganizationUnit> branchRepository){
        return new BranchRelationshipInMemoryRepository(branchRepository);
    }

    @Bean
    @Profile("InMemoryRepository")
    PartyRelationShipRepository<WorkstationOwnership> workstationRelationshipRepository(){
        return new WorkstationRelationshipInMemoryRepository();
    }

}
