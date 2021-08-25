package com.pictet.technologies.opensource.graphqldemo.repository;

import com.pictet.technologies.opensource.graphqldemo.model.Trip;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "trip", path = "trip")
public interface TripRepository extends PagingAndSortingRepository<Trip, Long> {

    @NotNull
    Optional<Trip> findById(@NotNull @Param("id")Long id);
}
