package com.pictet.technologies.opensource.graphqldemo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class FlightBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Flight flight;

    private String seatNumber;
}
