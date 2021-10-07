package com.pictet.technologies.opensource.graphqldemo.service;

import com.pictet.technologies.opensource.graphqldemo.model.Trip;
import com.pictet.technologies.opensource.graphqldemo.repository.ClientRepository;
import com.pictet.technologies.opensource.graphqldemo.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TripService {

    private final TripRepository tripRepository;
    private final ClientRepository clientRepository;

    public Trip getTrip(Long id) {
        return tripRepository.findById(id).get();
    }

    public Trip createTrip(Trip trip) {
        clientRepository.save(trip.getClient());
        return tripRepository.save(trip);
    }

    public Trip updateTrip(Long tripId, Trip newTrip) {
        Trip trip = tripRepository.findById(tripId).get();
        clientRepository.save(newTrip.getClient());
        trip.setClient(newTrip.getClient());
        trip.setName(newTrip.getName());
        return tripRepository.save(trip);
    }

    public void deleteTrip(Long tripId) {
        tripRepository.deleteById(tripId);
    }
}
