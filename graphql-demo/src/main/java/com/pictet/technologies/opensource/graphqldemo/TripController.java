package com.pictet.technologies.opensource.graphqldemo;

import com.pictet.technologies.opensource.graphqldemo.model.Trip;
import com.pictet.technologies.opensource.graphqldemo.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/trips")
public class TripController {

    private final TripService tripService;

    @GetMapping("/{tripId}")
    public ResponseEntity<Trip> getTrip(@PathVariable final  Long tripId) {
        return ResponseEntity.ok(tripService.getTrip(tripId));
    }
}

//
