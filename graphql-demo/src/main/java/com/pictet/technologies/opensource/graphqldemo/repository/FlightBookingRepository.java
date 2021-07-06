package com.pictet.technologies.opensource.graphqldemo.repository;

import com.pictet.technologies.opensource.graphqldemo.model.FlightBooking;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "flightBooking", path = "flightBooking")
public interface FlightBookingRepository extends PagingAndSortingRepository<FlightBooking, Long> {

}
