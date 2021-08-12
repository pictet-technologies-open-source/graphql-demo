package com.pictet.technologies.opensource.graphqldemo.repository;

import com.pictet.technologies.opensource.graphqldemo.model.Client;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "client", path = "client")
public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {

    List<Client> findByName(@Param("name") String name);

    Client findFirstByName(@Param("name") String name);

    @NotNull
    Optional<Client> findById(@NotNull @Param("id")Long id);

}
