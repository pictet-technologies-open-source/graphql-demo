package com.pictet.technologies.opensource.graphqldemo.repository;

import com.pictet.technologies.opensource.graphqldemo.model.Flight;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "flight", path = "flight")
public interface FlightRepository extends PagingAndSortingRepository<Flight, Long> {
}
