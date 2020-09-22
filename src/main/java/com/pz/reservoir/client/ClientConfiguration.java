package com.pz.reservoir.client;

import com.pz.reservoir.party.Car;
import com.pz.reservoir.party.PartyRepository;
import com.pz.reservoir.party.Person;
import com.pz.reservoir.preference.PreferenceTypeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
class ClientConfiguration {

    @Bean
    ClientFacade clientFacade(PartyRepository<Person> partyRepository, PartyRepository<Car> carPartyRepository, PreferenceTypeRepository preferenceTypeRepository){
        return new ClientFacade(partyRepository, carPartyRepository, preferenceTypeRepository);
    }

    @Bean
    @Profile("InMemoryRepository")
    PartyRepository<Person> personRepository(){
        return new ClientInMemoryRepository();
    }

    @Bean
    @Profile("InMemoryRepository")
    PartyRepository<Car> carRepository(){
        return new CarInMemoryRepository();
    }
}
