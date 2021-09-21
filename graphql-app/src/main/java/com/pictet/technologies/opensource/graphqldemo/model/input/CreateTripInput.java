package com.pictet.technologies.opensource.graphqldemo.model.input;

import com.pictet.technologies.opensource.graphqldemo.model.Client;
import com.pictet.technologies.opensource.graphqldemo.model.FlightBooking;
import lombok.Data;
import java.util.List;

@Data
public class CreateTripInput {

    private String name;

    private Client client;

    private List<FlightBooking> flightBookings;
}
