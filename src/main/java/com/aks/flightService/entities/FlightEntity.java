package com.aks.flightService.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;

@Entity
@Table(name="FLIGHT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String flightNumber;
    private String flightName;
    private String source;
    private String destination;
    private LocalDate flightDate;
    private OffsetDateTime flightTime;
    private String flightDuration;
    private CountryCode countryCode;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fareId")
    @JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer"})
    private FareEntity fare;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flightInfoId")
    @JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer"})
    private FlightInfoEntity flightInfo;

}
