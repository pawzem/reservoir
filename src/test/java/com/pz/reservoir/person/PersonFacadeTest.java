package com.pz.reservoir.person;

import com.pz.reservoir.buisness.dto.Employee;
import com.pz.reservoir.person.dto.*;
import com.pz.reservoir.party.PartyIdFactory;
import com.pz.reservoir.relationship.RelationshipIdentifier;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class PersonFacadeTest {

    private final PersonFacade personFacade = new PersonFacade(new PersonInMemoryRepository(),
            new CarInMemoryRepository(),
            new VehicleOwnershipInMemoryRepository(),
            new PersonInMemoryRepository(),
            new EmploymentRelationshipInMemoryRepository());


    @Test
    void clientShouldBeAdded() {
        //given
        var clientDto = new Client( "PL +48 500 000 000", "dummy@email", "paweł", "name");

        //when
        var personId = personFacade.addClient(clientDto);

        //then
        assertAll(
                () -> assertNotNull(personId),
                () -> assertNotNull(personFacade.getClient(personId))
        );

    }

    @Test
    void ownershipShouldBeAdded() {
        //given

        var carDto = new ClientPreferences(PartyIdFactory.generate().getId(),
                CarType.CAR,
                TireStorage.WAREHOUSE,
                ServiceOption.JUST_TIRES,
                List.of("17'"),
                "SK12345",
                "BMW M4"
                );

        //when
        var ownershipId = personFacade.addCar(carDto);

        //then
        assertAll(
                () -> assertNotNull(ownershipId),
                () -> assertNotNull(personFacade.getRelationship(ownershipId))
        );

    }

    @Test
    void carShouldBeAdded() {
        //given

        var carDto = new ClientPreferences(PartyIdFactory.generate().getId(),
                CarType.CAR,
                TireStorage.WAREHOUSE,
                ServiceOption.JUST_TIRES,
                List.of("17'"),
                "SK12345",
                "BMW M4"
        );


        //when
        var ownershipId = personFacade.addCar(carDto);

        //then
        assertAll(
                () -> assertNotNull(ownershipId),
                () -> assertNotNull(personFacade.getRelationship(ownershipId)),
                () -> assertNotNull(personFacade.getCar(personFacade.getRelationship(ownershipId).getClientPartyRole().getParty()))
        );

    }

    @Test
    void addEmployee() {
        //given
//       add business facade to visualize flow
        Employee employeeDto = new Employee(UUID.randomUUID().toString(), "Adam", "Nowak");

        //when
        RelationshipIdentifier employmentId = personFacade.addEmployee(employeeDto);

        //then
        assertAll(
                () -> assertNotNull(employmentId),
                () -> assertNotNull(personFacade.getEmployment(employmentId)),
                () -> assertNotNull(personFacade.getEmployee(personFacade.getEmployment(employmentId).getClientPartyRole().getParty()))
        );
    }


}