package com.example.petproject.controllers;

import com.example.petproject.dtos.DocumentResponseDto;
import com.example.petproject.dtos.NotificationResponseDto;
import com.example.petproject.dtos.SendNotificationRequestDto;
import com.example.petproject.exceptions.ApiError;
import com.example.petproject.services.DocumentService;
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
import org.springframework.web.bind.annotation.*;

@Slf4j
@Tag(name = "Document controller V1")
@ApiResponses({
        @ApiResponse(responseCode = "400",
                description = "Bad Request",
                content = @Content(schema = @Schema(name = "Bad Request", implementation = ApiError.class),
                        mediaType = MediaType.APPLICATION_JSON_VALUE))
})
@RequiredArgsConstructor
@RestController
@RequestMapping("/document")
public class DocumentController {

    private final DocumentService documentService;

    @Operation(summary = "get all document")
    @ApiResponse(
            responseCode = "200",
            description = "Successful operation",
            content = @Content(schema = @Schema(name = "Successful operation", implementation = DocumentResponseDto.class),
                    mediaType = MediaType.APPLICATION_JSON_VALUE)
    )
    @GetMapping("/get/{id}")
    public DocumentResponseDto sendNotification(@PathVariable("id") String id) {
        return documentService.getAllDocuments();
    }
}
