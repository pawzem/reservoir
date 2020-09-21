package com.pz.reservoir.company;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CompanyConfiguration {

    @Bean
    CompanyFacade companyFacade(){
        return new CompanyFacade();
    }
}
