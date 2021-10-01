package com.pictet.technologies.opensource.graphqldemo.model.input;

import lombok.Data;
import java.util.List;

@Data
public class TripInput {

    private Long id;
    private String name;
    private ClientInput client;
    private List<FlightBookingInput> flightBookings;

}
