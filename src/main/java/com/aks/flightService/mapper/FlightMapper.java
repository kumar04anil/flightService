package com.aks.flightService.mapper;

import com.aks.flightService.entities.FlightEntity;
import com.aks.model.FlightDataDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;
import javax.validation.Valid;

import java.util.List;

/**
 * Mapper implementation for flight service to convert entity to dto and vice versa.
 */
@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface FlightMapper {
    FlightEntity map(FlightDataDto flightDataDto);
    FlightDataDto map (FlightEntity flightEntity);
    List<FlightDataDto> flightEntityToDtoList(List<FlightEntity> flightEntityList);
}
