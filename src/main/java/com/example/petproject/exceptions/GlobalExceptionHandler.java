package com.example.petproject.exceptions;

import jakarta.validation.ValidationException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.example.petproject.enums.ApiErrorCode.VALIDATION_EXCEPTION;


@Log4j2
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(ValidationException.class)
    public ApiError handleValidationException(RuntimeException exception) {
        log.error(exception.getMessage());

        return ApiError.builder()
                .message(exception.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .code(VALIDATION_EXCEPTION)
                .build();
    }


    @ExceptionHandler(NotificationIntegrationServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ApiError handleGetClientServiceResponseException(NotificationIntegrationServiceException exception) {
        log.error(exception.getMessage());
        return exception.getApiError();
    }
}
