package com.pictet.technologies.opensource.graphqldemo.repository;


import java.util.List;

import com.pictet.technologies.opensource.graphqldemo.model.Client;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "client", path = "client")
public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {

    List<Client> findByName(@Param("name") String name);

}
