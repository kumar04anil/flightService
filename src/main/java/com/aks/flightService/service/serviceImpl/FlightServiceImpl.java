package com.aks.flightService.service.serviceImpl;

import com.aks.flightService.entities.FlightEntity;
import com.aks.flightService.handler.DuplicateFlightException;
import com.aks.flightService.handler.FlightNotFoundException;
import com.aks.flightService.mapper.FlightMapper;
import com.aks.flightService.repository.FlightRepository;
import com.aks.flightService.service.FlightService;
import com.aks.model.FlightDataDto;
import com.aks.model.FlightFullResponseDataDto;
import com.aks.model.FlightListDataDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * Flight data service.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class FlightServiceImpl implements FlightService {

    @Autowired
    private final FlightMapper flightMapper;
    private final FlightRepository flightRepository;

    @Override
    public FlightListDataDto getFlightByFlightNumber(String flightNumber) {

            List<FlightEntity> flightEntityList = flightRepository.findByFlightNumber(flightNumber);
            if(CollectionUtils.isEmpty(flightEntityList)) {
                log.error("No flight mapping found for provided flight number:" + flightNumber);
                throw new FlightNotFoundException("No flight exist with supplied flightNumber " + flightNumber);
        }
        FlightListDataDto flightListDataDto = new FlightListDataDto();
        flightListDataDto.setFlightList(flightMapper.flightEntityToDtoList(flightEntityList));

        return flightListDataDto;
    }
    @Override
    public FlightFullResponseDataDto addNewAirLine(FlightDataDto flightDataDto) {
        FlightEntity flightEntity = flightMapper.map(flightDataDto);
        var olderFlightDetails = getFlightByFlightNumber(flightDataDto.getFlightNumber());
        if(Objects.nonNull(olderFlightDetails)) {
            log.error("Duplicate flight details, Flight details already exists :: " + olderFlightDetails);
            throw new DuplicateFlightException("Flight details already exists " + flightDataDto);
        }
        FlightFullResponseDataDto responseDataDto = new FlightFullResponseDataDto();
        var flightResponse = flightMapper.map(flightRepository.save(flightEntity));
        responseDataDto.setFlight(flightResponse);

        return responseDataDto;
    }

}
