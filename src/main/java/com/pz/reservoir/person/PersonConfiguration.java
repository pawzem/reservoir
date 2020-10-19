package com.pz.reservoir.person;

import com.pz.reservoir.party.Car;
import com.pz.reservoir.party.PartyRepository;
import com.pz.reservoir.party.Person;
import com.pz.reservoir.relationship.PartyRelationShipRepository;
import com.pz.reservoir.relationship.relationships.Employment;
import com.pz.reservoir.relationship.relationships.VehicleOwnership;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
class PersonConfiguration {

    @Bean
    PersonFacade clientFacade(PartyRepository<Person> partyRepository,
                              PartyRepository<Car> carPartyRepository,
                              PartyRelationShipRepository<VehicleOwnership> vehicleOwnershipPartyRelationShipRepository,
                              PartyRepository<Person> employeeRepository,
                              PartyRelationShipRepository<Employment> employmentRelationShipRepository){
        return new PersonFacade(partyRepository,
                carPartyRepository,
                vehicleOwnershipPartyRelationShipRepository,
                employeeRepository,
                employmentRelationShipRepository);
    }

    @Bean
    @Profile("InMemoryRepository")
    PartyRepository<Person> personRepository(){
        return new PersonInMemoryRepository();
    }

    @Bean
    @Profile("InMemoryRepository")
    PartyRepository<Car> carRepository(){
        return new CarInMemoryRepository();
    }

    @Bean
    @Profile("InMemoryRepository")
    PartyRelationShipRepository<VehicleOwnership> vehicleOwnershipRepository(){
        return new VehicleOwnershipInMemoryRepository();
    }


    @Bean
    @Profile("InMemoryRepository")
    PartyRelationShipRepository<Employment> employmentRelationShipRepository(){
        return new EmploymentRelationshipInMemoryRepository();
    }
}
