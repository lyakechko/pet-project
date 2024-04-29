package com.example.petproject.controllers;

import com.example.petproject.dtos.ResumeRequestDto;
import com.example.petproject.dtos.ResumeResponseDto;
import com.example.petproject.exceptions.ApiError;
import com.example.petproject.services.ResumeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Resume generate controller V3")
@ApiResponses({
        @ApiResponse(
                responseCode = "400",
                description = "Bad Request",
                content = @Content(schema = @Schema(name = "Bad Request", implementation = ApiError.class),
                        mediaType = MediaType.APPLICATION_JSON_VALUE)
        ),
        @ApiResponse(
                responseCode = "401",
                description = "Unauthorized",
                content = @Content(schema = @Schema(name = "Unauthorized", implementation = ApiError.class),
                        mediaType = MediaType.APPLICATION_JSON_VALUE)
        ),
        @ApiResponse(
                responseCode = "500",
                description = "Server error",
                content = @Content(schema = @Schema(name = "Server error", implementation = ApiError.class),
                        mediaType = MediaType.APPLICATION_JSON_VALUE)
        )
})
@RequiredArgsConstructor
@RestController
@RequestMapping("/resume")
public class ResumeController {
    private final ResumeService resumeService;

    @Operation(summary = "Get a statement document")
    @ApiResponse(
            responseCode = "200",
            description = "Ok",
            content = @Content(schema = @Schema(name = "Ok", implementation = ResumeResponseDto.class),
                    mediaType = MediaType.APPLICATION_JSON_VALUE)
    )
    @PostMapping("/generation")
    public ResumeResponseDto getStatement(@RequestBody @Validated ResumeRequestDto request) {
        return resumeService.getResume(request);
    }

}
