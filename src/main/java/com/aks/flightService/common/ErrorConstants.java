package com.aks.flightService.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * This class is used to declare application wide error constants.
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorConstants {
    public static final String FLIGHT_NOT_FOUND_DESC = "flightds/notfound";
    public static final String FLIGHT_NOT_FOUND = "Flight not found";

}
