package com.example.petproject.controllers;

import com.example.petproject.dtos.NotificationResponseDto;
import com.example.petproject.dtos.SendNotificationRequestDto;
import com.example.petproject.exceptions.ApiError;
import com.example.petproject.services.NotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Tag(name = "Notification controller V1")
@ApiResponses({
        @ApiResponse(responseCode = "400",
                description = "Bad Request",
                content = @Content(schema = @Schema(name = "Bad Request", implementation = ApiError.class),
                        mediaType = MediaType.APPLICATION_JSON_VALUE))
})
@RequiredArgsConstructor
@RestController
@RequestMapping("/notification")
public class NotificationController {
    private final NotificationService notificationService;


    @Operation(summary = "Send single notification")
    @ApiResponse(
            responseCode = "200",
            description = "Successful operation",
            content = @Content(schema = @Schema(name = "Successful operation", implementation = NotificationResponseDto.class),
                    mediaType = MediaType.APPLICATION_JSON_VALUE)
    )
    @PostMapping("/send")
    public NotificationResponseDto sendNotification(@RequestBody @Validated SendNotificationRequestDto requestDto) {
        return notificationService.sendNotification(requestDto);
    }
}
