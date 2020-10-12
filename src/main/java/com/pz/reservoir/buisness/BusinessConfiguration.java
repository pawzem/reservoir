package com.pz.reservoir.buisness;

import com.pz.reservoir.party.Company;
import com.pz.reservoir.party.OrganizationUnit;
import com.pz.reservoir.party.PartyRepository;
import com.pz.reservoir.relationship.PartyRelationShipRepository;
import com.pz.reservoir.relationship.relationships.CompanyBranch;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
class BusinessConfiguration {

    @Bean
    BusinessFacade companyFacade(PartyRepository<Company> companyRepository,
                                 PartyRepository<OrganizationUnit> branchRepository,
                                 PartyRelationShipRepository<CompanyBranch> branchRelationshipRepository){
        return new BusinessFacade(companyRepository, branchRepository, branchRelationshipRepository);
    }

    @Bean
    @Profile("InMemoryRepository")
    PartyRepository<Company> companyRepository(){
        return new CompanyInMemoryRepository();
    }

    @Bean
    @Profile("InMemoryRepository")
    PartyRepository<OrganizationUnit> branchRepository(){
        return new BranchInMemoryRepository();
    }

    @Bean
    @Profile("InMemoryRepository")
    PartyRelationShipRepository<CompanyBranch> branchRelationshipRepository(){
        return new BranchRelationshipInMemoryRepository();
    }
}
