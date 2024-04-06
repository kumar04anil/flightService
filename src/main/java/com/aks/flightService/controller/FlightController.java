package com.aks.flightService.controller;

import com.aks.api.AirlineApi;
import com.aks.flightService.service.FlightService;
import com.aks.model.FlightDataDto;
import com.aks.model.FlightFullResponseDataDto;
import com.aks.model.FlightListDataDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for performing Flight CRUD operation.
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class FlightController implements AirlineApi {

    @Autowired
    FlightService flightService;

    @Override
    public ResponseEntity<FlightFullResponseDataDto> addNewAirLine(FlightDataDto flightDataDto) {
        log.info("Inside controller ::addNewAirLine:: flightDataDto::" + flightDataDto);
        return new ResponseEntity<>(flightService.addNewAirLine(flightDataDto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FlightListDataDto> getFlightMappingForFlightNumber(String flightNumber) {
        log.info("Inside controller ::getFlightMappingForFlightNumber:: flightNumber::" + flightNumber);
        return new ResponseEntity<>(flightService.getFlightByFlightNumber(flightNumber), HttpStatus.OK);
    }
}
