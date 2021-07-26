package com.pictet.technologies.opensource.graphqldemo.service;

import com.pictet.technologies.opensource.graphqldemo.model.Trip;
import com.pictet.technologies.opensource.graphqldemo.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TripService {

    private final TripRepository tripRepository;

    public Trip getTrip(Long id) {
        return tripRepository.findById(id).get();
    }
}
