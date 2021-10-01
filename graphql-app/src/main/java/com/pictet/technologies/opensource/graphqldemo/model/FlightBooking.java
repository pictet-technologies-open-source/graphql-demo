package com.pictet.technologies.opensource.graphqldemo.model;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@Accessors(chain = true)
public class FlightBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    private Flight flight;

    private String seatNumber;
}
