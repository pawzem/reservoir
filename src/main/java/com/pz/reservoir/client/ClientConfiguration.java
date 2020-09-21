package com.pz.reservoir.client;

import com.pz.reservoir.party.PartyRepository;
import com.pz.reservoir.party.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
class ClientConfiguration {

    @Bean
    ClientFacade clientFacade(PartyRepository<Person> partyRepository){
        return new ClientFacade(partyRepository);
    }

    @Bean
    @Profile("InMemoryRepository")
    PartyRepository<Person> partyRepository(){
        return new ClientInMemoryRepository();
    }
}
