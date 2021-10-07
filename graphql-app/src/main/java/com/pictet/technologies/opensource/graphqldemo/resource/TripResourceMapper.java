package com.pictet.technologies.opensource.graphqldemo.resource;

import com.pictet.technologies.opensource.graphqldemo.model.Client;
import com.pictet.technologies.opensource.graphqldemo.model.Trip;
import org.springframework.stereotype.Component;

@Component
public class TripResourceMapper {

    public Trip toEntity(TripResource tripResource) {

        return new Trip()
            .setName(tripResource.getName())
            .setClient(new Client().setName(tripResource.getClient().getName()));
    }
}
