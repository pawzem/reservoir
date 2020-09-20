package com.pz.reservoir.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ClientConfiguration {

    @Bean
    ClientFacade clientFacade(){
        return new ClientFacade();
    }
}
