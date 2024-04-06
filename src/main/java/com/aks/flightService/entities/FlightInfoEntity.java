package com.aks.flightService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FLIGHT_INFO")
public class FlightInfoEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String flightNumber;
    private String flightType;
    private int numberOfSeats;
    private FlightStatus flightStatus;

}
