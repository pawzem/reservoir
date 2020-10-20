package com.pz.reservoir.reservation;

import com.pz.reservoir.party.PartyRepository;
import com.pz.reservoir.party.Person;
import com.pz.reservoir.person.PersonInMemoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
class ReservationConfiguration {

    @Bean
    ReservationFacade reservationFacade(ScheduleRepository<Schedule> scheduleRepository){
        return new ReservationFacade(scheduleRepository);
    }

    @Bean
    @Profile("InMemoryRepository")
    ScheduleRepository<Schedule> scheduleRepository(){
        return new ScheduleInMemoryRepository();
    }

}
