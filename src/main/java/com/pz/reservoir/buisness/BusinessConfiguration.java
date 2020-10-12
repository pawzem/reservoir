package com.pz.reservoir.buisness;

import com.pz.reservoir.party.Company;
import com.pz.reservoir.party.PartyRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
class BusinessConfiguration {

    @Bean
    BusinessFacade companyFacade(PartyRepository<Company> companyRepository){
        return new BusinessFacade(companyRepository);
    }

    @Bean
    @Profile("InMemoryRepository")
    PartyRepository<Company> companyRepository(){
        return new CompanyInMemoryRepository();
    }
}
