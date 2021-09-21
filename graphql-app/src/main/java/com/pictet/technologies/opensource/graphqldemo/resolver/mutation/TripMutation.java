package com.pictet.technologies.opensource.graphqldemo.resolver.mutation;

import com.pictet.technologies.opensource.graphqldemo.model.Trip;
import com.pictet.technologies.opensource.graphqldemo.model.input.CreateTripInput;
import com.pictet.technologies.opensource.graphqldemo.repository.TripRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TripMutation implements GraphQLMutationResolver {

    private final TripRepository tripRepository;

    public Trip createTrip(CreateTripInput input) {
        return tripRepository.save(new Trip()
            .setClient(input.getClient())
            .setName(input.getName())
            .setFlightBookings(input.getFlightBookings())
        );
    }
}
