package com.aks.flightService.handler;

/**
 * Custom exception for FlightNotFound.
 */
public class FlightNotFoundException extends RuntimeException {
    public FlightNotFoundException(String message) {
        super(message);
    }
}
