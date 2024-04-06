package com.aks.flightService.handler;

import com.aks.flightService.common.ErrorConstants;
import com.aks.model.ErrorResponseDataDto;
import com.aks.model.ErrorResponseSubDetailsInner;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * This class will be used for mentioning all the exception.
 */
@RequiredArgsConstructor
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvisor {

    private ErrorResponseDataDto buildErrorResponseRestDto(String type, String title, int code,
                                                           String status, String detail,
                                                           Exception ex) {
        ErrorResponseDataDto errorResponseRestDto = new ErrorResponseDataDto();
        errorResponseRestDto.setTimestamp(LocalDateTime.now().toString());
        errorResponseRestDto.setInstance(System.getenv("FLIGHT_ENV"));
        errorResponseRestDto.setType(type);
        errorResponseRestDto.setTitle(title);
        errorResponseRestDto.setCode(String.valueOf(code));
        errorResponseRestDto.setStatus(status);
        errorResponseRestDto.setStatus(status);
        errorResponseRestDto.setDetail(detail);
        List<ErrorResponseSubDetailsInner> subDetails = new ArrayList<>();
        ErrorResponseSubDetailsInner subDetail = new ErrorResponseSubDetailsInner();
        subDetail.setCode(String.valueOf(code));
        subDetail.setMessage(ex.getMessage());
        subDetails.add(subDetail);
        errorResponseRestDto.setSubDetails(subDetails);
        return errorResponseRestDto;
    }

    /**
     * This method handles FlightNotFoundException, and return the specific message into the Response body.
     *
     * @param ex The occurred exception.
     * @return The Response Entity Object along with exception message.
     */
    @ExceptionHandler(FlightNotFoundException.class)
    public ResponseEntity<ErrorResponseDataDto> handleFlightNotFoundException(FlightNotFoundException ex) {
        ErrorResponseDataDto errorResponse = buildErrorResponseRestDto(
                ErrorConstants.FLIGHT_NOT_FOUND_DESC,
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.name(),
                ErrorConstants.FLIGHT_NOT_FOUND, ex);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * This method handles DuplicateFlightException, and return the specific message into the Response body.
     *
     * @param ex The occurred exception.
     * @return The Response Entity Object along with exception message.
     */
    @ExceptionHandler(DuplicateFlightException.class)
    public ResponseEntity<ErrorResponseDataDto> handleDuplicateFlightException(DuplicateFlightException ex) {
        ErrorResponseDataDto errorResponse = buildErrorResponseRestDto(
                ErrorConstants.FLIGHT_NOT_FOUND_DESC,
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.name(),
                ErrorConstants.FLIGHT_NOT_FOUND, ex);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
