package com.example.petproject.exceptions;

import com.example.petproject.enums.ApiErrorCode;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiError implements Serializable {
    private HttpStatus status;
    private String message;
    private ApiErrorCode code;
}
