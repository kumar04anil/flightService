package com.aks.flightService.service;

import com.aks.model.FlightDataDto;
import com.aks.model.FlightFullResponseDataDto;
import com.aks.model.FlightListDataDto;

/**
 * Flight data service.
 */
public interface FlightService {
    FlightFullResponseDataDto addNewAirLine(FlightDataDto flightDataDto);

    FlightListDataDto getFlightByFlightNumber(String flightNumber);
}
