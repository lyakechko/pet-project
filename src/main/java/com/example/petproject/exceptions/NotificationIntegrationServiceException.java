package com.example.petproject.exceptions;

import com.example.petproject.enums.ApiErrorCode;
import lombok.Getter;

@Getter
public class NotificationIntegrationServiceException extends RuntimeException {
    private ApiError apiError;
    private ApiErrorCode apiErrorCode;

    public NotificationIntegrationServiceException(ApiError apiError) {
        this.apiError = apiError;
    }

    public NotificationIntegrationServiceException(ApiErrorCode apiErrorCode, String message) {
        super(message);
        this.apiErrorCode = apiErrorCode;
    }
}