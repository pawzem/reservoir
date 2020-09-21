package com.pz.reservoir.client;

import com.pz.reservoir.party.PartyRepository;
import com.pz.reservoir.party.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ClientConfiguration {

    @Bean
    ClientFacade clientFacade(PartyRepository<Person> partyRepository){
        //TODO in memory repo
        return new ClientFacade(partyRepository);
    }
}
