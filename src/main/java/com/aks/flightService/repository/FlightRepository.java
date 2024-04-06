package com.aks.flightService.repository;

import com.aks.flightService.entities.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This is repo for FlightData entity.
 */
@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Long> {
    //@EntityGraph(attributePaths = {"fare"})
    @Query(value = "from FlightEntity f where f.flightNumber= :flightNumber")
    List<FlightEntity> findByFlightNumber(String flightNumber);

}
