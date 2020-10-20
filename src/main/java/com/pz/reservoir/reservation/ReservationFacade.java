package com.pz.reservoir.reservation;

import com.pz.reservoir.reservation.dto.ReservationRequest;
import lombok.AllArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

@AllArgsConstructor
public class ReservationFacade {

    private ScheduleRepository<Schedule> scheduleRepository;

    public ScheduleId reserve(ReservationRequest reservation){

      var schedule = scheduleRepository.findByDate(reservation.getStartTime().toLocalDate())
              .orElseGet(() -> createNewSchedule(reservation));

      schedule.reserve(reservation.getClient(), reservation.getStartTime(), reservation.getDuration());


      return scheduleRepository.save(schedule);
    }

    private Schedule createNewSchedule(ReservationRequest reservation) {
        return ScheduleFactory.createNew(reservation.getStartTime().toLocalDate());
    }

    public ScheduleId cancel(ScheduleId scheduleId){
        return ScheduleId.of();
    }

    public ScheduleId cancel(LocalDateTime startTime, LocalDateTime endTime){
        return ScheduleId.of();
    }

    public boolean isAvailable(LocalDateTime dateTime, Duration serviceDuration) {
        Optional<Schedule> schedule = scheduleRepository.findByDate(dateTime.toLocalDate());
        return schedule.map(s -> s.isAvailable(dateTime, serviceDuration))
                .orElse(Boolean.TRUE);
    }
}
