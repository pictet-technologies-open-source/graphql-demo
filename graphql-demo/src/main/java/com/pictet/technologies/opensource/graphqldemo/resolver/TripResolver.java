package com.pictet.technologies.opensource.graphqldemo.resolver;

import com.pictet.technologies.opensource.graphqldemo.model.Client;
import com.pictet.technologies.opensource.graphqldemo.model.FlightBooking;
import com.pictet.technologies.opensource.graphqldemo.model.Trip;
import com.pictet.technologies.opensource.graphqldemo.repository.ClientRepository;
import com.pictet.technologies.opensource.graphqldemo.repository.FlightBookingRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class TripResolver implements GraphQLQueryResolver {

    private final ClientRepository clientRepository;
    private final FlightBookingRepository flightBookingRepository;

    public Trip trip(Long id) {
        log.info("Returning trip with id {}", id);
        return Trip.builder()
            .id(id)
            .name("trip-name")
            .client(clientRepository.findFirstByName("Jane"))
            .flightBookings((List<FlightBooking>) flightBookingRepository.findAll())
            .build();
    }
}