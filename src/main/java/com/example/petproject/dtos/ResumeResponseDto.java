package com.example.petproject.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResumeResponseDto {
    private byte [] resume;
}
