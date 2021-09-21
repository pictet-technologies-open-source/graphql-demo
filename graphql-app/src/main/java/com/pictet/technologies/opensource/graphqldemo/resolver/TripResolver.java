package com.pictet.technologies.opensource.graphqldemo.resolver;

import com.pictet.technologies.opensource.graphqldemo.model.Trip;
import com.pictet.technologies.opensource.graphqldemo.repository.TripRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class TripResolver implements GraphQLQueryResolver {

    private final TripRepository tripRepository;

    public Trip trip(Long id) {
        log.info("Returning trip with id {}", id);
        Optional<Trip> trip = tripRepository.findById(id);

        return trip.map(value -> Trip.builder()
            .id(value.getId())
            .name(value.getName())
            .client(value.getClient())
            .flightBookings(value.getFlightBookings())
            .build()).orElse(null);
    }
}
