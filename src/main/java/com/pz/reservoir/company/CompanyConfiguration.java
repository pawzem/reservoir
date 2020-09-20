package com.pz.reservoir.company;

import com.pz.reservoir.party.Company;
import org.springframework.context.annotation.Configuration;

@Configuration
class CompanyConfiguration {

    CompanyFacade companyFacade(){
        return new CompanyFacade();
    }
}
