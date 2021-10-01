package com.pictet.technologies.opensource.graphqldemo.resolver.mutation;

import com.pictet.technologies.opensource.graphqldemo.model.Client;
import com.pictet.technologies.opensource.graphqldemo.model.Trip;
import com.pictet.technologies.opensource.graphqldemo.model.input.ClientInput;
import com.pictet.technologies.opensource.graphqldemo.model.input.TripInput;
import com.pictet.technologies.opensource.graphqldemo.repository.ClientRepository;
import com.pictet.technologies.opensource.graphqldemo.repository.TripRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TripMutation implements GraphQLMutationResolver {

    private final TripRepository tripRepository;
    private final ClientRepository clientRepository;

    public Trip createTrip(TripInput tripInput) {

        Client client;
        final ClientInput inputClient = tripInput.getClient();
        final Long clientId = inputClient.getId();

        if (clientId == null || !clientRepository.existsById(clientId)) {
            client = clientRepository.save(new Client().setAge(inputClient.getAge()).setName(inputClient.getName()));
        } else {
            client = clientRepository.findById(clientId).get();
            clientRepository.save(client.setAge(inputClient.getAge()).setName(inputClient.getName()));
        }

        return tripRepository.save(new Trip()
            .setClient(client)
            .setName(tripInput.getName())
        );
    }

    public Trip updateTrip(Long id, String name) {

        final Optional<Trip> optionalTrip = tripRepository.findById(id);

        if (!optionalTrip.isPresent()) {
            throw new IllegalArgumentException("Trip with id " + id + " not found");
        }

        Trip trip = optionalTrip.get();
        trip.setName(name);
        return tripRepository.save(trip);
    }

    public Trip updateTripUsingTripInputObject(TripInput input) {

        Long id = input.getId();
        final Optional<Trip> optionalTrip = tripRepository.findById(id);

        if (!optionalTrip.isPresent()) {
            throw new IllegalArgumentException("Trip with id " + id + " not found");
        }

        Trip trip = optionalTrip.get();
        trip.setName(input.getName());
        return tripRepository.save(trip);
    }

    public Trip deleteTrip(Long id) {

        final Optional<Trip> optionalTrip = tripRepository.findById(id);
        if (!optionalTrip.isPresent()) {
            throw new IllegalArgumentException("Trip with id " + id + " not found");
        }

        Trip trip = optionalTrip.get();
        tripRepository.deleteById(id);

        return trip;
    }
}
