package com.aks.flightService.handler;

/**
 * Custom exception for DuplicateFlight.
 */
public class DuplicateFlightException extends RuntimeException {
    public DuplicateFlightException(String message) {
        super(message);
    }
}
