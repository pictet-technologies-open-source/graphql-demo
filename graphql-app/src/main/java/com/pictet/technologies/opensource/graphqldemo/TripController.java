package com.pictet.technologies.opensource.graphqldemo;

import com.pictet.technologies.opensource.graphqldemo.model.Trip;
import com.pictet.technologies.opensource.graphqldemo.resource.TripResource;
import com.pictet.technologies.opensource.graphqldemo.resource.TripResourceMapper;
import com.pictet.technologies.opensource.graphqldemo.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/trips")
public class TripController {

    private final TripService tripService;
    private final TripResourceMapper mapper;

    @GetMapping("/{tripId}")
    public ResponseEntity<Trip> getTrip(@PathVariable final Long tripId) {
        return ResponseEntity.ok(tripService.getTrip(tripId));
    }

    @PostMapping
    public ResponseEntity<URI> createTrip(@RequestBody TripResource trip) {
        Long id = tripService.createTrip(mapper.toEntity(trip)).getId();

        UriComponents uriComponents = UriComponentsBuilder
            .newInstance()
            .path("/api/v1/trips/{id}").buildAndExpand(id);
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @PutMapping("/{tripId}")
    public ResponseEntity<Trip> updateTrip(@PathVariable final Long tripId, @RequestBody TripResource trip) {
        return ResponseEntity.ok(tripService.updateTrip(tripId, mapper.toEntity(trip)));
    }

    @DeleteMapping("/{tripId}")
    public ResponseEntity<Void> deleteTrip(@PathVariable final Long tripId) {
        tripService.deleteTrip(tripId);
        return ResponseEntity.ok().build();
    }
}

