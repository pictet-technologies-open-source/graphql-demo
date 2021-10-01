package com.pictet.technologies.opensource.graphqldemo.model.input;

import lombok.Data;

@Data
public class FlightBookingInput {

    private Long id;
    private FlightInput flight;
    private String seatNumber;

}
